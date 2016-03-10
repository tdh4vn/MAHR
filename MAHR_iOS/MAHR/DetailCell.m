//
//  DetailCell.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "DetailCell.h"
#import "Constant.h"

@implementation DetailCell

- (void)awakeFromNib {
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

- (void)setValueFrom:(int)startValue to:(int)finishValue;
{
    
    _lblFrom.text = [NSString stringWithFormat:@"%d",startValue];
    _lblTo.text = [NSString stringWithFormat:@"%d",finishValue];
    
}


@end
