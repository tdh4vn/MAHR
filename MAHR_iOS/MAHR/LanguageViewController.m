//
//  LanguageViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "LanguageViewController.h"
#import "MoreCell.h"
#import "Constant.h"
#import "HexColors.h"

@interface LanguageViewController ()
@property(nonatomic,strong) UIBarButtonItem *barItem;
@end

@implementation LanguageViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    
    [self.navigationItem setHidesBackButton:TRUE];
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"背部" style:UIBarButtonItemStyleBordered target:self action:@selector(btnCancelDidTouch)];
    self.navigationItem.leftBarButtonItem = _barItem;
    
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"好" style:UIBarButtonItemStyleBordered target:self action:@selector(btnDoneDidTouch)];
    self.navigationItem.rightBarButtonItem = _barItem;
    
    _tbvLanguage.tableFooterView = [[UIView alloc]init];
    
    self.title = @"语 言";
    
    _tbvLanguage.allowsMultipleSelection = YES;
    
    [_tbvLanguage reloadData];
}



#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return 3;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"moreCell";
    
    MoreCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"MoreCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    if (indexPath.row == VietNam) {
        cell.lblTitle.text = @"越南";
        if ([_selectedRows containsObject:@"vn"]) {
            UIImage *image = [[UIImage imageNamed:@"check"] imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
            cell.imvCheck.image = image;
            [cell.imvCheck setTintColor:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor]];
        }
    } else if (indexPath.row == Taiwan) {
        cell.lblTitle.text = @"中国";
        if ([_selectedRows containsObject:@"cn"]) {
            UIImage *image = [[UIImage imageNamed:@"check"] imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
            cell.imvCheck.image = image;
            [cell.imvCheck setTintColor:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor]];
        }
    } else if (indexPath.row == Indonesia) {
        cell.lblTitle.text = @"印尼";
        if ([_selectedRows containsObject:@"id"]) {
            UIImage *image = [[UIImage imageNamed:@"check"] imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
            cell.imvCheck.image = image;
            [cell.imvCheck setTintColor:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor]];
        }
    }
    
    
    
    
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(nonnull NSIndexPath *)indexPath{

    
    if (indexPath.row == VietNam) {
        if ([_selectedRows containsObject:@"vn"]) {
            [_selectedRows removeObject:@"vn"];
        } else {
            [_selectedRows addObject:@"vn"];
        }
    } else if (indexPath.row == Taiwan) {
        if ([_selectedRows containsObject:@"cn"]) {
            [_selectedRows removeObject:@"cn"];
        } else {
            [_selectedRows addObject:@"cn"];
        }
    } else if (indexPath.row == Indonesia) {
        if ([_selectedRows containsObject:@"id"]) {
            [_selectedRows removeObject:@"id"];
        } else {
            [_selectedRows addObject:@"id"];
        }
    }
    
    [_tbvLanguage reloadData];
}

#pragma mark - Class funtion

- (void)btnCancelDidTouch;
{
    CATransition* transition = [CATransition animation];
    transition.duration = 0.3f;
    transition.type = kCATransitionReveal;
    transition.subtype = kCATransitionFromBottom;
    [self.navigationController.view.layer addAnimation:transition
                                                forKey:kCATransition];
    [self.navigationController popViewControllerAnimated:NO];
    
}

- (void)btnDoneDidTouch;
{
    
    [[NSNotificationCenter defaultCenter] postNotificationName:@"language" object:_selectedRows];
    
    CATransition* transition = [CATransition animation];
    transition.duration = 0.3f;
    transition.type = kCATransitionReveal;
    transition.subtype = kCATransitionFromBottom;
    [self.navigationController.view.layer addAnimation:transition
                                                forKey:kCATransition];
    [self.navigationController popViewControllerAnimated:NO];
    
    
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
