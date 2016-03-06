//
//  WorkerViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "WorkerViewController.h"
#import "WorkerCell.h"

@interface WorkerViewController ()

@end

@implementation WorkerViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.title = @"Lọc";
    _tbvWorker.rowHeight = 65.0f;
    
    _tbvWorker.tableFooterView = [[UIView alloc]init];
    
    
    
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return 10;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"workerCell";
    
    WorkerCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"WorkerCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    cell.imageView.image = [UIImage imageNamed:@"1"];
    cell.lblName.text = @"Nguyễn Văn A";
    cell.lblAge.text = @"20";
    cell.lblExpertise.text = @"Cơ khí";
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    [tableView deselectRowAtIndexPath:indexPath animated:NO];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
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
