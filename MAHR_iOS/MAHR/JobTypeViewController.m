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
#import "Constant.h"

@implementation JobTypeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [_btnMaleWorker custom];
    [_btnFemaleWorker custom];
    [_btnHouseMaid custom];
    
    self.title = @"职位类型";
    
}

- (IBAction)btnMaleWorkerDidTouch:(id)sender {
    
    JobDetailViewController *jobDetailViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobDetail"];
    
    jobDetailViewController.region = _region;
    jobDetailViewController.jobType = @"job_worker_male";
    
    [self.navigationController pushViewController:jobDetailViewController animated:YES];
    
}

- (IBAction)btnFemaleWorkerDidTouch:(id)sender;
{
    
    JobDetailViewController *jobDetailViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobDetail"];
    
    jobDetailViewController.region = _region;
    jobDetailViewController.jobType = @"job_worker_female";
    
    [self.navigationController pushViewController:jobDetailViewController animated:YES];
    
}


- (IBAction)btnHouseMaidWorkerDidTouch:(id)sender;
{
    
    JobDetailViewController *jobDetailViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobDetail"];
    
    jobDetailViewController.region = _region;

    jobDetailViewController.jobType = @"job_house_cleaner";
    
    [self.navigationController pushViewController:jobDetailViewController animated:YES];
    
}


@end
