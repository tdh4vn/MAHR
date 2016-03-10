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
#import "HexColors.h"
#import "SCLAlertView.h"
#import "AppDelegate.h"
#import "Skill.h"
#import "EducationViewController.h"
#import "LanguageViewController.h"
#import "SkillViewController.h"
#import "UIButton+Custom.h"

@interface JobDetailViewController ()

@property(nonatomic,strong) NSMutableArray *skills;

@property(nonatomic,strong) UIBarButtonItem *barItem;

@property(nonatomic,strong) NSMutableArray *expertises;

@property(nonatomic,assign) int ageFrom;
@property(nonatomic,assign) int ageTo;

@property(nonatomic,assign) int heightFrom;
@property(nonatomic,assign) int heightTo;

@property(nonatomic,assign) int weightFrom;
@property(nonatomic,assign) int weightTo;

@property(nonatomic,strong) NSMutableArray *languages;

@property(nonatomic,assign) int experienceFrom;
@property(nonatomic,assign) int experienceTo;

@property(nonatomic,assign) int educationType;

@end

@implementation JobDetailViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.view.backgroundColor = [UIColor whiteColor];
    
    [_btnFilter custom];
    
    _expertises = [[NSMutableArray alloc]init];
    
    _ageFrom = 0;
    _ageTo = 100;
    
    _heightFrom = 0;
    _heightTo = 200;
    
    _weightFrom = 0;
    _weightTo = 200;
    
    _languages = [[NSMutableArray alloc]init];
    
    _experienceFrom = 0;
    _experienceTo = 100;
    
    _educationType = JuniorHigh;
    
    
    
    
    _tbvDetails.rowHeight = 65.0f;
    
    _tbvDetails.tableFooterView = [[UIView alloc]init];
    
    self.navigationItem.rightBarButtonItem = _barItem;
    
}



- (void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:animated];
    
    
    
    if (!_skills) {
        _skills = [[NSMutableArray alloc]init];
    }
    
    AppDelegate *appDelegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
    _skills = appDelegate.skills;
    
    if (_jobType == MaleWorker) {
        self.title = @"男性厂";
    } else if (_jobType == FemaleWorker){
        self.title = @"女工厂";
    } else if (_jobType == HouseMaid){
        self.title = @"室友";
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
        
        cell.lblDetail.text = @"专门 知识";
        cell.imageView.image = [UIImage imageNamed:@"0"];
        cell.lblFrom.hidden = YES;
        cell.lblMinus.hidden = YES;
        NSString *skillString = [[NSString alloc]init];
        for (Skill *skill in _expertises) {
            skillString = [skillString stringByAppendingString:[NSString stringWithFormat:@"%@, ",skill.chineseName]];
        }
        
        if (skillString.length>0) {
            skillString = [skillString substringToIndex:skillString.length - 2];
        }
        
        cell.lblTo.text = skillString;
        
    } else if (indexPath.row == Age){
        
        cell.lblDetail.text = @"年 龄";
        cell.imageView.image = [UIImage imageNamed:@"1"];
        [cell setValueFrom:_ageFrom to:_ageTo];
        
    } else if (indexPath.row == Height){
        
        cell.lblDetail.text = @"高 度";
        cell.imageView.image = [UIImage imageNamed:@"2"];
        [cell setValueFrom:_heightFrom to:_heightTo];
        
    } else if (indexPath.row == Weight){
        
        cell.lblDetail.text = @"重 量";
        cell.imageView.image = [UIImage imageNamed:@"3"];
        [cell setValueFrom:_weightFrom to:_weightTo];
        
    } else if (indexPath.row == Language){
        
        cell.lblDetail.text = @"语 言";
        cell.imageView.image = [UIImage imageNamed:@"4"];
        cell.lblFrom.hidden = YES;
        cell.lblMinus.hidden = YES;
        NSString *languagesString = [[NSString alloc]init];
        for (NSString *language in _languages) {
            if([language isEqualToString:@"VN"]){
                languagesString = [languagesString stringByAppendingString:[NSString stringWithFormat:@"越南, "]];
            } else if ([language isEqualToString:@"CN"]){
                languagesString = [languagesString stringByAppendingString:[NSString stringWithFormat:@"中国, "]];
            } else if ([language isEqualToString:@"ID"]){
                languagesString = [languagesString stringByAppendingString:[NSString stringWithFormat:@"印尼, "]];
            }
        }
        
        if (languagesString.length>0) {
            languagesString = [languagesString substringToIndex:languagesString.length - 2];
        }
        
        cell.lblTo.text = languagesString;
        
    } else if (indexPath.row == Experience){
        
        cell.lblDetail.text = @"经 验";
        cell.imageView.image = [UIImage imageNamed:@"5"];
        [cell setValueFrom:_experienceFrom to:_experienceTo];
        
    } else if (indexPath.row == Education){
        
        cell.lblDetail.text = @"学 位";
        cell.imageView.image = [UIImage imageNamed:@"6"];
        cell.lblFrom.hidden = YES;
        cell.lblMinus.hidden = YES;
        if (_educationType == JuniorHigh) {
            cell.lblTo.text = @"中學";
        } else if (_educationType == High){
            cell.lblTo.text = @"高中";
        } else if (_educationType == College){
            cell.lblTo.text = @"學院";
        } else if (_educationType == University){
            cell.lblTo.text = @"大學";
        }
        
    }
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(nonnull NSIndexPath *)indexPath{
    [tableView deselectRowAtIndexPath:indexPath animated:NO];
    
    
    if (indexPath.row == Expertise) {
        
        SkillViewController *skillMoreViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"skill"];
        skillMoreViewController.selectedRows = _expertises;
        skillMoreViewController.skills = _skills;
        
        CATransition* transition = [CATransition animation];
        transition.duration = 0.3f;
        transition.type = kCATransitionMoveIn;
        transition.subtype = kCATransitionFromTop;
        [self.navigationController.view.layer addAnimation:transition
                                                    forKey:kCATransition];
        [skillMoreViewController setHidesBottomBarWhenPushed:YES];
        [self.navigationController pushViewController:skillMoreViewController animated:NO];

        
        
    } else if (indexPath.row == Age){
        
        SCLAlertView *alert = [[SCLAlertView alloc] initWithNewWindow];
        alert.tintTopCircle = NO;
        alert.iconTintColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
        alert.useLargerIcon = NO;
        alert.cornerRadius = 13.0f;
        
        SCLTextView *fromField = [alert addTextField:[NSString stringWithFormat:@"%d 岁的",_ageFrom]];
        fromField.keyboardType = UIKeyboardTypeNumberPad;
        
        SCLTextView *toField = [alert addTextField:[NSString stringWithFormat:@"%d 岁的",_ageTo]];
        toField.keyboardType = UIKeyboardTypeNumberPad;
        
        [alert addButton:@"好" actionBlock:^{
            if (fromField.text.length != 0) {
                _ageFrom = [self intFromString:fromField.text];
            }
            
            if (toField.text.length != 0) {
                _ageTo = [self intFromString:toField.text];
            }
            
            [_tbvDetails reloadData];
        }];
        
        
        [alert showCustom:self image:[UIImage imageNamed:@"1"] color:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor] title:nil subTitle:nil closeButtonTitle:nil duration:0.0f];
        
        [fromField becomeFirstResponder];
        
    } else if (indexPath.row == Height){
        
        SCLAlertView *alert = [[SCLAlertView alloc] initWithNewWindow];
        alert.tintTopCircle = NO;
        alert.iconTintColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
        alert.useLargerIcon = NO;
        alert.cornerRadius = 13.0f;
        
        SCLTextView *fromField = [alert addTextField:[NSString stringWithFormat:@"%d cm",_heightFrom]];
        fromField.keyboardType = UIKeyboardTypeNumberPad;
        
        SCLTextView *toField = [alert addTextField:[NSString stringWithFormat:@"%d cm",_heightTo]];
        toField.keyboardType = UIKeyboardTypeNumberPad;
        
        [alert addButton:@"好" actionBlock:^{
            if (fromField.text.length != 0) {
                _heightFrom = [self intFromString:fromField.text];
            }
            
            if (toField.text.length != 0) {
                _heightTo = [self intFromString:toField.text];
            }
            
            [_tbvDetails reloadData];
        }];
        
        
        [alert showCustom:self image:[UIImage imageNamed:@"2"] color:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor] title:nil subTitle:nil closeButtonTitle:nil duration:0.0f];
        
        [fromField becomeFirstResponder];
        
    } else if (indexPath.row == Weight){
        
        SCLAlertView *alert = [[SCLAlertView alloc] initWithNewWindow];
        alert.tintTopCircle = NO;
        alert.iconTintColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
        alert.useLargerIcon = NO;
        alert.cornerRadius = 13.0f;
        
        SCLTextView *fromField = [alert addTextField:[NSString stringWithFormat:@"%d kg",_weightFrom]];
        fromField.keyboardType = UIKeyboardTypeNumberPad;
        
        SCLTextView *toField = [alert addTextField:[NSString stringWithFormat:@"%d kg",_weightTo]];
        toField.keyboardType = UIKeyboardTypeNumberPad;
        
        [alert addButton:@"好" actionBlock:^{
            if (fromField.text.length != 0) {
                _weightFrom = [self intFromString:fromField.text];
            }
            
            if (toField.text.length != 0) {
                _weightTo = [self intFromString:toField.text];
            }
            
            [_tbvDetails reloadData];
        }];
        
        
        [alert showCustom:self image:[UIImage imageNamed:@"3"] color:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor] title:nil subTitle:nil closeButtonTitle:nil duration:0.0f];
        
        [fromField becomeFirstResponder];
        
    } else if (indexPath.row == Language){
        
        LanguageViewController *languageMoreViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"language"];
        languageMoreViewController.selectedRows = _languages;
        
        CATransition* transition = [CATransition animation];
        transition.duration = 0.3f;
        transition.type = kCATransitionMoveIn;
        transition.subtype = kCATransitionFromTop;
        [self.navigationController.view.layer addAnimation:transition
                                                    forKey:kCATransition];
        [languageMoreViewController setHidesBottomBarWhenPushed:YES];
        [self.navigationController pushViewController:languageMoreViewController animated:NO];
        
    } else if (indexPath.row == Experience){
        SCLAlertView *alert = [[SCLAlertView alloc] initWithNewWindow];
        alert.tintTopCircle = NO;
        alert.iconTintColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
        alert.useLargerIcon = NO;
        alert.cornerRadius = 13.0f;
        
        SCLTextView *fromField = [alert addTextField:[NSString stringWithFormat:@"%d 年",_experienceFrom]];
        fromField.keyboardType = UIKeyboardTypeNumberPad;
        
        SCLTextView *toField = [alert addTextField:[NSString stringWithFormat:@"%d 年",_experienceTo]];
        toField.keyboardType = UIKeyboardTypeNumberPad;
        
        [alert addButton:@"好" actionBlock:^{
            if (fromField.text.length != 0) {
                _experienceFrom = [self intFromString:fromField.text];
            }
            
            if (toField.text.length != 0) {
                _experienceTo = [self intFromString:toField.text];
            }
            
            [_tbvDetails reloadData];
        }];
        
        
        [alert showCustom:self image:[UIImage imageNamed:@"5"] color:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor] title:nil subTitle:nil closeButtonTitle:nil duration:0.0f];
        
        [fromField becomeFirstResponder];
        
    } else if (indexPath.row == Education){
     
        //[self showJobMoreViewWithJobDetail:Education type:_educationType];
        EducationViewController *educationMoreViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"education"];
        educationMoreViewController.selectedRow = _educationType - 1;
        
        CATransition* transition = [CATransition animation];
        transition.duration = 0.3f;
        transition.type = kCATransitionMoveIn;
        transition.subtype = kCATransitionFromTop;
        [self.navigationController.view.layer addAnimation:transition
                                                    forKey:kCATransition];
        [educationMoreViewController setHidesBottomBarWhenPushed:YES];
        [self.navigationController pushViewController:educationMoreViewController animated:NO];
        
    }
    
}

#pragma mark - Class funtion

- (void)reloadExpertise:(NSNotification *)notification;
{
    _expertises = [notification object];
}

- (void)reloadLanguage:(NSNotification *)notification;
{
    _languages = [notification object];
}

- (void)reloadEducation:(NSNotification *)notification;
{
    _educationType = [[notification object] intValue];
    
}

- (IBAction)btnFilterDidTouch:(id)sender;
{
    WorkerViewController *workerViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"worker"];
    
    NSString *filters = [[NSString alloc]init];
    
    if (_expertises.count > 0) {
        filters = [filters stringByAppendingString:@"&filter[]=exps+include+"];
        for (Skill *skill in _expertises) {
            filters = [filters stringByAppendingString:[NSString stringWithFormat:@"%@,",skill.id]];
        }
        filters = [filters substringToIndex:filters.length - 1];
    }
    
    filters = [filters stringByAppendingString:[NSString stringWithFormat:@"&filter[]=age+beetween+%d,%d",_ageFrom,_ageTo]];
    filters = [filters stringByAppendingString:[NSString stringWithFormat:@"&filter[]=height+beetween+%d,%d",_heightFrom,_heightTo]];
    filters = [filters stringByAppendingString:[NSString stringWithFormat:@"&filter[]=weight+beetween+%d,%d",_weightFrom,_weightTo]];
    if (_languages.count > 0) {
        filters = [filters stringByAppendingString:@"&filter[]=langs+include+"];
        for (NSString *language in _languages) {
            filters = [filters stringByAppendingString:[NSString stringWithFormat:@"%@,",language]];
        }
        filters = [filters substringToIndex:filters.length - 1];
    }
    filters = [filters stringByAppendingString:[NSString stringWithFormat:@"&filter[]=exp_year+beetween+%d,%d",_experienceFrom,_experienceTo]];
    filters = [filters stringByAppendingString:[NSString stringWithFormat:@"&filter[]=educational_level+gte+%d",_educationType]];
    filters = [filters stringByAppendingString:[NSString stringWithFormat:@"&filter[]=major+eq+gte+%d",_jobType]];
    filters = [filters stringByAppendingString:[NSString stringWithFormat:@"&filter[]=nation+eq+%@",_region]];
    
    NSString *filterUrl = [NSString stringWithFormat:kFilterUrl,filters];
    
    workerViewController.filterUrl = filterUrl;
    
    
    CATransition* transition = [CATransition animation];
    transition.duration = 0.3f;
    transition.type = kCATransitionMoveIn;
    transition.subtype = kCATransitionFromBottom;
    [self.navigationController.view.layer addAnimation:transition
                                                forKey:kCATransition];
    [workerViewController setHidesBottomBarWhenPushed:YES];
    [self.navigationController pushViewController:workerViewController animated:NO];
}

- (int)intFromString:(NSString *)string;
{
    NSNumberFormatter *formatter = [[NSNumberFormatter alloc]init];
    formatter.numberStyle = NSNumberFormatterDecimalStyle;
    NSNumber *number = [formatter numberFromString:string];
    return [number intValue];

}

- (void)btnDoneDidTouch;
{
    [_tbvDetails becomeFirstResponder];
}

@end
