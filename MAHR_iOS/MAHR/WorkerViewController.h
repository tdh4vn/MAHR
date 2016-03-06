//
//  WorkerViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"

@interface WorkerViewController : MainViewController<UITableViewDelegate,UITableViewDataSource>

@property (weak, nonatomic) IBOutlet UITableView *tbvWorker;

@end
