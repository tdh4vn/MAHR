//
//  RegionViewController.h
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"


@interface RegionViewController : MainViewController
@property (weak, nonatomic) IBOutlet UIButton *btnVietNam;
@property (weak, nonatomic) IBOutlet UIButton *btnIndonesia;

- (IBAction)btnVietNamDidTouch:(id)sender;
- (IBAction)btnIndonesiaDidTouch:(id)sender;

@end
