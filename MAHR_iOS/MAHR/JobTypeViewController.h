//
//  JobTypeViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"

@interface JobTypeViewController : MainViewController

@property(nonatomic,strong) NSString *region;
@property (weak, nonatomic) IBOutlet UIButton *btnMaleWorker;
@property (weak, nonatomic) IBOutlet UIButton *btnFemaleWorker;
@property (weak, nonatomic) IBOutlet UIButton *btnHouseMaid;

- (IBAction)btnMaleWorkerDidTouch:(id)sender;
- (IBAction)btnFemaleWorkerDidTouch:(id)sender;
- (IBAction)btnHouseMaidWorkerDidTouch:(id)sender;

@end
