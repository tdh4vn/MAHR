//
//  JobDetailViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"

@interface JobDetailViewController : MainViewController<UITabBarDelegate,UITableViewDataSource>

@property(nonatomic,strong) NSString *region;
@property(nonatomic,strong) NSString *jobType;

@property (weak, nonatomic) IBOutlet UITableView *tbvDetails;

@end
