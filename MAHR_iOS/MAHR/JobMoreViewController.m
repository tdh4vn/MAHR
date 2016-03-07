//
//  JobMoreViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "JobMoreViewController.h"
#import "Constant.h"
#import "JobDetailViewController.h"
#import "MoreCell.h"
#import "HexColors.h"

@interface JobMoreViewController ()

@property(nonatomic,strong) UIBarButtonItem *barItem;

@end

@implementation JobMoreViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    [self.navigationItem setHidesBackButton:TRUE];
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"Huỷ" style:UIBarButtonItemStyleBordered target:self action:@selector(btnCancelDidTouch)];
    self.navigationItem.leftBarButtonItem = _barItem;
    
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"Xong" style:UIBarButtonItemStyleBordered target:self action:@selector(btnDoneDidTouch)];
    self.navigationItem.rightBarButtonItem = _barItem;
    
    _tbvMore.tableFooterView = [[UIView alloc]init];
    
}

- (void)viewDidAppear:(BOOL)animated{
    [super viewWillAppear:animated];
    
    if (_jobDetailType == Expertise) {
        self.title = @"Sở trường";
    } else if (_jobDetailType == Language){
        self.title = @"Ngôn ngữ";
    } else if (_jobDetailType == Education){
        self.title = @"Trình độ";
    }
    
    [_tbvMore reloadData];
    
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    if (_jobDetailType == Expertise) {
        return 7;
    } else if (_jobDetailType == Language){
        return 3;
    } else {
        return 4;
    }
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"moreCell";
    
    MoreCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"MoreCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    if (_jobDetailType == Expertise) {
        
        if (indexPath.row == CNC) {
            cell.lblTitle.text = @"CNC";
        } else if (indexPath.row == Textile){
            cell.lblTitle.text = @"Dệt";
        } else if (indexPath.row == Mechanical){
            cell.lblTitle.text = @"Cơ khí";
        } else if (indexPath.row == Carpentry){
            cell.lblTitle.text = @"Mộc";
        } else if (indexPath.row == Welding){
            cell.lblTitle.text = @"Hàn";
        } else if (indexPath.row == Electronic){
            cell.lblTitle.text = @"Điện tử";
        } else if (indexPath.row == Food){
            cell.lblTitle.text = @"Thực phẩm";
        }
        
    } else if (_jobDetailType == Language){
        
        if (indexPath.row == VietNam) {
            cell.lblTitle.text = @"Việt Nam";
        } else if (indexPath.row == Taiwan) {
            cell.lblTitle.text = @"Đài Loan";
        } else if (indexPath.row == Indonesia) {
            cell.lblTitle.text = @"Indonesia";
        }
        
    } else {
        if (indexPath.row == JuniorHigh) {
            cell.lblTitle.text = @"Trung học cơ sở";
        } else if (indexPath.row == High) {
            cell.lblTitle.text = @"Trung học phổ thông";
        } else if (indexPath.row == College) {
            cell.lblTitle.text = @"Cao đẳng";
        } else if (indexPath.row == University) {
            cell.lblTitle.text = @"Đại học";
        }
    }
    
    if (indexPath.row != _selectedRow) {
        cell.imvCheck.hidden = YES;
    } else {
        UIImage *image = [[UIImage imageNamed:@"check"] imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
        cell.imvCheck.image = image;
        [cell.imvCheck setTintColor:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor]];

    }
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(nonnull NSIndexPath *)indexPath{
    _selectedRow = (int)indexPath.row;
    [_tbvMore reloadData];
}

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
    
    if (_jobDetailType == Expertise) {
        [[NSNotificationCenter defaultCenter] postNotificationName:@"expertise" object:[NSNumber numberWithInt:_selectedRow]];
    } else if (_jobDetailType == Language){
        [[NSNotificationCenter defaultCenter] postNotificationName:@"language" object:[NSNumber numberWithInt:_selectedRow]];
    } else if (_jobDetailType == Education){
        [[NSNotificationCenter defaultCenter] postNotificationName:@"education" object:[NSNumber numberWithInt:_selectedRow]];
    }
    
    CATransition* transition = [CATransition animation];
    transition.duration = 0.3f;
    transition.type = kCATransitionReveal;
    transition.subtype = kCATransitionFromBottom;
    [self.navigationController.view.layer addAnimation:transition
                                                forKey:kCATransition];
    [self.navigationController popViewControllerAnimated:NO];
    
    
}

@end
