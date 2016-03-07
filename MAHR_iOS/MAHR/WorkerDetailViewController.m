//
//  WorkerDetailViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "WorkerDetailViewController.h"
#import "UIWebView+AFNetworking.h"
#import "AFNetworking.h"
#import "Constant.h"
#import "HexColors.h"

@interface WorkerDetailViewController ()

@property(nonatomic,strong) UIBarButtonItem *barItem;

@end

@implementation WorkerDetailViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.title = @"Nguyễn Văn A";
    
    _barItem = [[UIBarButtonItem alloc]initWithImage:[UIImage imageNamed:@"share"] style:UIBarButtonItemStyleBordered target:self action:@selector(btnShareDidTouch)];
    
    
    _viewWeb.backgroundColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
    
    NSString *stringUrl = @"https://docs.google.com/gview?embedded=true&url=techkids.edu.vn/YT001%20NGUYEN%20VAN%20TRUNG-修理發動機、電焊.xls";
    
    
    NSString *encoded = [stringUrl stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding];
    
    NSURLRequest *request = [[NSURLRequest alloc]initWithURL:[NSURL URLWithString:encoded]];
    
    [_viewWeb loadRequest:request progress:nil success:^NSString * _Nonnull(NSHTTPURLResponse * _Nonnull response, NSString * _Nonnull HTML) {
        
        [_viewWeb loadHTMLString:HTML baseURL:nil];
        
        self.navigationItem.rightBarButtonItem = _barItem;
        
        return HTML;
    } failure:^(NSError * _Nonnull error) {
        NSLog(@"%@",error);
    }];
    
}


- (void)btnShareDidTouch;
{
    NSString *textToShare = @"https://docs.google.com/gview?embedded=true&url=techkids.edu.vn/YT001%20NGUYEN%20VAN%20TRUNG-修理發動機、電焊.xls";
    
    NSArray *objectsToShare = @[textToShare];
    
    UIActivityViewController *activityVC = [[UIActivityViewController alloc] initWithActivityItems:objectsToShare applicationActivities:nil];
    activityVC.view.tintColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
    
    NSArray *excludeActivities = @[UIActivityTypeAirDrop,
                                   UIActivityTypePrint,
                                   UIActivityTypeAssignToContact,
                                   UIActivityTypeSaveToCameraRoll,
                                   UIActivityTypeAddToReadingList,
                                   UIActivityTypePostToFlickr,
                                   UIActivityTypePostToVimeo];
    
    activityVC.excludedActivityTypes = excludeActivities;
    
    [self presentViewController:activityVC animated:YES completion:nil];
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
