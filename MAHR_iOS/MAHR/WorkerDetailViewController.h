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

@end
