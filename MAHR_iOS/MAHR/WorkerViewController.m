//
//  WorkerViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "WorkerViewController.h"
#import "WorkerCell.h"
#import "WorkerDetailViewController.h"
#import "AFNetworking/AFNetworking.h"

@interface WorkerViewController ()
@property(nonatomic,strong) UIBarButtonItem *barItem;
@property(nonatomic,strong) NSMutableArray *workers;
@end

@implementation WorkerViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [self.navigationItem setHidesBackButton:TRUE];
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"背部" style:UIBarButtonItemStyleBordered target:self action:@selector(btnCancelDidTouch)];
    self.navigationItem.leftBarButtonItem = _barItem;
    
    self.title = @"搜尋";
    _tbvWorker.rowHeight = 80.0f;
    
    _tbvWorker.tableFooterView = [[UIView alloc]init];
    
    if (!_workers) {
        _workers = [[NSMutableArray alloc]init];
    }
    
    [_workers removeAllObjects];
    [_tbvWorker reloadData];
    
    [self loadWorker];
}

- (void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:animated];
    
    
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return _workers.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"workerCell";
    
    WorkerCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"WorkerCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    [cell cellWithWorker:_workers[indexPath.row]];
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    [tableView deselectRowAtIndexPath:indexPath animated:NO];
    
    WorkerDetailViewController *workerDetailViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"workDetail"];
    
    [self.navigationController pushViewController:workerDetailViewController animated:YES];
    
}


#pragma mark - Class funtion

- (void)btnCancelDidTouch;
{
    CATransition* transition = [CATransition animation];
    transition.duration = 0.3f;
    transition.type = kCATransitionReveal;
    transition.subtype = kCATransitionFromTop;
    [self.navigationController.view.layer addAnimation:transition
                                                forKey:kCATransition];
    [self.navigationController popViewControllerAnimated:NO];
    
}

- (void)loadWorker;
{
    NSLog(@"%@",_filterUrl);
    
    NSURLSessionConfiguration *configuration  = [NSURLSessionConfiguration defaultSessionConfiguration];
    AFHTTPSessionManager *httpSessionManager = [[AFHTTPSessionManager alloc]initWithSessionConfiguration:configuration];
    
    NSURLSessionDataTask *dataTask = [httpSessionManager GET:_filterUrl
                                                  parameters:nil progress:nil
                                                     success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
                                                         if (responseObject) {
                                                             for (NSDictionary *jsonDict in responseObject[@"items"]) {
                                                                 Worker *newWorker = [[Worker alloc]initWithJson:jsonDict];
                                                                 [_workers addObject:newWorker];
                                                             }
                                                             [_tbvWorker reloadData];
                                                             
                                                             
                                                         }
                                                     } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
                                                         if (error) {
                                                             NSLog(@"%@",error);
                                                         }
                                                     }];
    [dataTask resume];
    
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
