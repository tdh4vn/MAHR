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

@property(nonatomic,assign) NSString *region;
@property(nonatomic,assign) int jobType;

@property (weak, nonatomic) IBOutlet UITableView *tbvDetails;
@property (weak, nonatomic) IBOutlet UILabel *lblConnection;

@end
