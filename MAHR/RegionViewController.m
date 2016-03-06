//
//  RegionViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "RegionViewController.h"
#import "HexColors.h"
#import "Constant.h"
#import "JobTypeViewController.h"
#import "UIButton+Custom.h"

@interface RegionViewController ()

@end

@implementation RegionViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.

    [_btnVietNam custom];
    
    [_btnIndonesia custom];
    
    
    
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

- (IBAction)btnVietNamDidTouch:(id)sender {
    
    JobTypeViewController *jobTypeViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobType"];
    
    jobTypeViewController.region = @"Việt Nam";
    
    [self.navigationController pushViewController:jobTypeViewController animated:YES];

    
}

- (IBAction)btnIndonesiaDidTouch:(id)sender {
    
    JobTypeViewController *jobTypeViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"jobType"];
    
    jobTypeViewController.region = @"Indonesina";
    
    [self.navigationController pushViewController:jobTypeViewController animated:YES];
    
}
@end
