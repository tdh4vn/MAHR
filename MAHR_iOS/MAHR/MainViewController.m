//
//  MainViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "MainViewController.h"
#import "HexColors.h"
#import "Constant.h"

@implementation MainViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.navigationController.navigationBar.titleTextAttributes = @{NSForegroundColorAttributeName: [UIColor hx_colorWithHexRGBAString:kNavigationBarBackGroundColor]};
    
//    self.navigationController.navigationBar.backgroundColor = [UIColor hx_colorWithHexRGBAString:kNavigationBarBackGroundColor];
    
}

@end
