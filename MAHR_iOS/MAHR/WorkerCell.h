//
//  WorkerCell.h
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "Worker.h"
#import <UIKit/UIKit.h>

@interface WorkerCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UIImageView *imView;
@property (weak, nonatomic) IBOutlet UILabel *lblName;
@property (weak, nonatomic) IBOutlet UILabel *lblAge;
@property (weak, nonatomic) IBOutlet UILabel *lblHeight;
@property (weak, nonatomic) IBOutlet UILabel *lblWeight;
@property (weak, nonatomic) IBOutlet UIImageView *imvStatus;

- (void)cellWithWorker:(Worker *)worker;

@end
