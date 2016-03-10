//
//  SkillViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"

@interface SkillViewController : MainViewController<UITableViewDataSource,UITableViewDelegate>

@property (weak, nonatomic) IBOutlet UITableView *tbvSkill;
@property(nonatomic,strong) NSMutableArray *selectedRows;
@property(nonatomic,strong) NSMutableArray *skills;

@end
