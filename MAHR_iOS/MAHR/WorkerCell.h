//
//  WorkerCell.h
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface WorkerCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UIImageView *imView;
@property (weak, nonatomic) IBOutlet UILabel *lblName;
@property (weak, nonatomic) IBOutlet UILabel *lblExpertise;
@property (weak, nonatomic) IBOutlet UILabel *lblAge;


@end
