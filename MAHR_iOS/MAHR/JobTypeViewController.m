//
//  JobTypeViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "JobTypeViewController.h"
#import "UIButton+Custom.h"
#import "JobDetailViewController.h"

@implementation JobTypeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [_btnMaleWorker custom];
    [_btnFemaleWorker custom];
    [_btnHouseMaid custom];
    
    
    self.title = _region;
    
}

- (IBAction)btnMaleWorkerDidTouch:(id)sender {
    
    JobDetailViewController *jobDetailViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobDetail"];
    
    jobDetailViewController.region = _region;
    jobDetailViewController.jobType = @"Công xưởng nam";
    
    [self.navigationController pushViewController:jobDetailViewController animated:YES];
    
}

- (IBAction)btnFemaleWorkerDidTouch:(id)sender;
{
    
    JobDetailViewController *jobDetailViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobDetail"];
    
    jobDetailViewController.region = _region;
    jobDetailViewController.jobType = @"Công xưởng nữ";
    
    [self.navigationController pushViewController:jobDetailViewController animated:YES];
    
}


- (IBAction)btnHouseMaidWorkerDidTouch:(id)sender;
{
    
    JobDetailViewController *jobDetailViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobDetail"];
    
    jobDetailViewController.region = _region;

    jobDetailViewController.jobType = @"Giúp việc gia đình";
    
    [self.navigationController pushViewController:jobDetailViewController animated:YES];
    
}


@end
