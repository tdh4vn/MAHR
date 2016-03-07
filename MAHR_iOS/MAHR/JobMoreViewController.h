//
//  JobMoreViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"

@interface JobMoreViewController : MainViewController<UITabBarDelegate,UITableViewDataSource>

@property(nonatomic,assign) int jobDetailType;

@property (weak, nonatomic) IBOutlet UITableView *tbvMore;

@property(nonatomic,assign) int selectedRow;

@end
