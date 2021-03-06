//
//  EducationViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "EducationViewController.h"
#import "MoreCell.h"
#import "Constant.h"
#import "HexColors.h"

@interface EducationViewController ()
@property(nonatomic,strong) UIBarButtonItem *barItem;
@end

@implementation EducationViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    _tbvEducation.rowHeight = 50.0f;
    
    [self.navigationItem setHidesBackButton:TRUE];
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"背部" style:UIBarButtonItemStyleBordered target:self action:@selector(btnCancelDidTouch)];
    self.navigationItem.leftBarButtonItem = _barItem;
    
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"好" style:UIBarButtonItemStyleBordered target:self action:@selector(btnDoneDidTouch)];
    self.navigationItem.rightBarButtonItem = _barItem;
    
    _tbvEducation.tableFooterView = [[UIView alloc]init];
    
    self.title = @"学 位";
    
    [_tbvEducation reloadData];
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return 6;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"moreCell";
    
    MoreCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"MoreCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    if (indexPath.row == Primary - 1) {
        cell.lblTitle.text = @"小學";
    } else if (indexPath.row == JuniorHigh - 1) {
        cell.lblTitle.text = @"中學";
    } else if (indexPath.row == High - 1) {
        cell.lblTitle.text = @"高中";
    } else if (indexPath.row == Vocational - 1) {
        cell.lblTitle.text = @"中級";
    } else if (indexPath.row == College - 1) {
        cell.lblTitle.text = @"二專";
    } else if (indexPath.row == University - 1) {
        cell.lblTitle.text = @"大學";
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
    [_tbvEducation reloadData];
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
    
    [[NSNotificationCenter defaultCenter] postNotificationName:@"education" object:[NSNumber numberWithInt:_selectedRow + 1]];
    
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
