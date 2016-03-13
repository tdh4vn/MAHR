//
//  WorkerDetailViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Worker.h"

@interface WorkerDetailViewController : UIViewController

@property(nonatomic,strong) Worker *selectedWorker;
@property (weak, nonatomic) IBOutlet UIWebView *viewWeb;
@property (weak, nonatomic) IBOutlet UIButton *btnUse;
@property (weak, nonatomic) IBOutlet UIButton *btnShare;
@property (weak, nonatomic) IBOutlet UIButton *btnConfirm;


- (IBAction)btnUseDidTouch:(id)sender;
- (IBAction)btnShareDidTouch:(id)sender;
- (IBAction)btnConfirmDidTouch:(id)sender;



@end
