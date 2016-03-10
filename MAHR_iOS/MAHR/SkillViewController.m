//
//  SkillViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//


#import "SkillViewController.h"
#import "HexColors.h"
#import "MoreCell.h"
#import "Constant.h"
#import "Skill.h"

@interface SkillViewController ()
@property(nonatomic,strong) UIBarButtonItem *barItem;
@end

@implementation SkillViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [self.navigationItem setHidesBackButton:TRUE];
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"背部" style:UIBarButtonItemStyleBordered target:self action:@selector(btnCancelDidTouch)];
    self.navigationItem.leftBarButtonItem = _barItem;
    
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"好" style:UIBarButtonItemStyleBordered target:self action:@selector(btnDoneDidTouch)];
    self.navigationItem.rightBarButtonItem = _barItem;
    
    _tbvSkill.tableFooterView = [[UIView alloc]init];
    
    self.title = @"专门 知识";
    
    [_tbvSkill reloadData];
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return _skills.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"moreCell";
    
    MoreCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"MoreCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    cell.lblTitle.text = [_skills[indexPath.row] chineseName];
    if ([_selectedRows containsObject:_skills[indexPath.row]]) {
        UIImage *image = [[UIImage imageNamed:@"check"] imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
        cell.imvCheck.image = image;
        [cell.imvCheck setTintColor:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor]];
    }
    
    
    
    
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(nonnull NSIndexPath *)indexPath{
    
    if ([_selectedRows containsObject:_skills[indexPath.row]]) {
        [_selectedRows removeObject:_skills[indexPath.row]];
    } else {
        [_selectedRows addObject:_skills[indexPath.row]];
    }
    
    [_tbvSkill reloadData];
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
    
    [[NSNotificationCenter defaultCenter] postNotificationName:@"expertise" object:_selectedRows];
    
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
