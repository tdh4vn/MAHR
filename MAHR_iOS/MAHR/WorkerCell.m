//
//  WorkerCell.m
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "WorkerCell.h"
#import "UIImageView+WebCache.h"
#import "Constant.h"

@implementation WorkerCell

- (void)awakeFromNib {
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

- (void)cellWithWorker:(Worker *)worker;
{
    UIImage *placeholer = [UIImage imageNamed:@"1"];
    
    if ([worker.avatarUrl isEqualToString:@""]) {
        _imView.image = placeholer;
    } else {
        [_imView sd_setImageWithURL:[NSURL URLWithString:worker.avatarUrl] completed:^(UIImage *image, NSError *error, SDImageCacheType cacheType, NSURL *imageURL) {
            
        }];
    }
    
    _lblName.text = worker.name;
    _lblAge.text = worker.age;
    _lblHeight.text = [NSString stringWithFormat:@"%@ cm",worker.height];
    _lblWeight.text = [NSString stringWithFormat:@"%@ kg",worker.weight];
    
    if (worker.status == 1) {
        _imvStatus.image = [UIImage imageNamed:kStatusGreenImage];
    } else if (worker.status == 2) {
        _imvStatus.image = [UIImage imageNamed:kStatusYellowImage];
    } else if (worker.status == 3) {
        _imvStatus.image = [UIImage imageNamed:kStatusRedImage];
    }
}

@end
