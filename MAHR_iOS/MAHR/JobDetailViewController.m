//
//  JobDetailViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "JobDetailViewController.h"
#import "DetailCell.h"
#import "WorkerViewController.h"
#import "Constant.h"
#import "JobMoreViewController.h"
#import "HexColors.h"

@interface JobDetailViewController ()

@property(nonatomic,strong) UIBarButtonItem *barItem;

@property(nonatomic,assign) int expertiseType;

@property(nonatomic,assign) int ageFrom;
@property(nonatomic,assign) int ageTo;

@property(nonatomic,assign) int heightFrom;
@property(nonatomic,assign) int heightTo;

@property(nonatomic,assign) int weightFrom;
@property(nonatomic,assign) int weightTo;

@property(nonatomic,assign) int languageType;

@property(nonatomic,assign) int experienceFrom;
@property(nonatomic,assign) int experienceTo;

@property(nonatomic,assign) int educationType;

@end

@implementation JobDetailViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    
    _expertiseType = CNC;
    
    _ageFrom = 18;
    _ageTo = 30;
    
    _heightFrom = 100;
    _heightTo = 200;
    
    _weightFrom = 40;
    _weightTo = 100;
    
    _languageType = VietNam;
    
    _experienceFrom = 0;
    _experienceTo = 10;
    
    _educationType = JuniorHigh;
    
    
    
    
    _tbvDetails.rowHeight = 65.0f;
    
    _tbvDetails.tableFooterView = [[UIView alloc]init];
    
    _barItem = [[UIBarButtonItem alloc]initWithTitle:@"Lọc" style:UIBarButtonItemStyleBordered target:self action:@selector(btnFilterDidTouch)];
    self.navigationItem.rightBarButtonItem = _barItem;
    
}

- (void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:animated];
    
    if (_jobType == MaleWorker) {
        self.title = @"Công xưởng nam";
    } else if (_jobType == FemaleWorker){
        self.title = @"Công xưởng nữ";
    } else if (_jobType == HouseMaid){
        self.title = @"Giúp việc gia đình";
    }
    
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(reloadExpertise:)
                                                 name:@"expertise"
                                               object:nil];
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(reloadLanguage:)
                                                 name:@"language"
                                               object:nil];
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(reloadEducation:)
                                                 name:@"education"
                                               object:nil];
    
    [_tbvDetails reloadData];
}

- (void)reloadExpertise:(NSNotification *)notification;
{
    _expertiseType = [[notification object] intValue];
}

- (void)reloadLanguage:(NSNotification *)notification;
{
    _languageType = [[notification object] intValue];
}

- (void)reloadEducation:(NSNotification *)notification;
{
    _educationType = [[notification object] intValue];

}

- (void)btnFilterDidTouch;
{
    WorkerViewController *workerViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"worker"];
    
    [self.navigationController pushViewController:workerViewController animated:YES];
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return 7;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"detailCell";
    
    DetailCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"DetailCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    if (indexPath.row == Expertise) {
        
        cell.lblDetail.text = @"Sở trường";
        cell.imageView.image = [UIImage imageNamed:@"0"];
        [cell setSingleValue:_expertiseType type:CNC];
        
    } else if (indexPath.row == Age){
        
        cell.lblDetail.text = @"Tuổi";
        cell.imageView.image = [UIImage imageNamed:@"1"];
        [cell setValueFrom:_ageFrom to:_ageTo];
        
    } else if (indexPath.row == Height){
        
        cell.lblDetail.text = @"Chiều cao";
        cell.imageView.image = [UIImage imageNamed:@"2"];
        [cell setValueFrom:_heightFrom to:_heightTo];
        
    } else if (indexPath.row == Weight){
        
        cell.lblDetail.text = @"Cân nặng";
        cell.imageView.image = [UIImage imageNamed:@"3"];
        [cell setValueFrom:_weightFrom to:_weightTo];
        
    } else if (indexPath.row == Language){
        
        cell.lblDetail.text = @"Ngôn ngữ";
        cell.imageView.image = [UIImage imageNamed:@"4"];
        [cell setSingleValue:_languageType type:Language];
        
    } else if (indexPath.row == Experience){
        
        cell.lblDetail.text = @"Kinh nghiệm";
        cell.imageView.image = [UIImage imageNamed:@"5"];
        [cell setValueFrom:_experienceFrom to:_experienceTo];
        
    } else if (indexPath.row == Education){
        
        cell.lblDetail.text = @"Trình độ";
        cell.imageView.image = [UIImage imageNamed:@"6"];
        [cell setSingleValue:_educationType type:Education];
        
    }
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(nonnull NSIndexPath *)indexPath{
    [tableView deselectRowAtIndexPath:indexPath animated:NO];
    
    
    if (indexPath.row == Expertise) {
        
        [self showJobMoreViewWithJobDetail:Expertise type:_expertiseType];
        
        
    } else if (indexPath.row == Age){
        UIAlertController *alert = [UIAlertController alertControllerWithTitle:@""
                                                                       message:nil
                                                                preferredStyle:UIAlertControllerStyleAlert];
        
        alert.view.tintColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
        
        NSAttributedString *attributedString = [[NSAttributedString alloc]initWithString:@"Tuổi" attributes:@{NSForegroundColorAttributeName: [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor]}];
        
        [alert setValue:attributedString forKey:@"attributedTitle"];
        UIAlertAction *cancel = [UIAlertAction actionWithTitle:@"Huỷ" style:UIAlertActionStyleDefault handler:^(UIAlertAction *action) {
            [alert dismissViewControllerAnimated:YES completion:nil];
        }];
        
        UIAlertAction *save = [UIAlertAction actionWithTitle:@"Xong" style:UIAlertActionStyleDefault handler:^(UIAlertAction *action) {
            
            
            
        }];
        
        [alert addAction:cancel];
        [alert addAction:save];
        
        [self presentViewController:alert animated:YES completion:nil];
        
    } else if (indexPath.row == Height){
        
        
    } else if (indexPath.row == Weight){
        
        
        
    } else if (indexPath.row == Language){
        
        [self showJobMoreViewWithJobDetail:Language type:_languageType];
        
    } else if (indexPath.row == Experience){
        
        
        
    } else if (indexPath.row == Education){
     
        [self showJobMoreViewWithJobDetail:Education type:_educationType];
        
    }
    
}

#pragma mark - Class funtion

- (void)showJobMoreViewWithJobDetail:(int)detail type:(int)type;
{
    JobMoreViewController *jobMoreViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobMore"];
    
    jobMoreViewController.jobDetailType = detail;
    jobMoreViewController.selectedRow = type;
    
    CATransition* transition = [CATransition animation];
    transition.duration = 0.3f;
    transition.type = kCATransitionMoveIn;
    transition.subtype = kCATransitionFromTop;
    [self.navigationController.view.layer addAnimation:transition
                                                forKey:kCATransition];
    [jobMoreViewController setHidesBottomBarWhenPushed:YES];
    [self.navigationController pushViewController:jobMoreViewController animated:NO];
}


@end
