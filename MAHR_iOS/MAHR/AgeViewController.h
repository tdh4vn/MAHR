//
//  AgeViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"

@interface AgeViewController : MainViewController

@property (weak, nonatomic) IBOutlet UITextField *txtFrom;
@property (weak, nonatomic) IBOutlet UITextField *txtTo;

@property (weak, nonatomic) IBOutlet UIButton *btnDone;
- (IBAction)btnDoneDidTouch:(id)sender;


@end
