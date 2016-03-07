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


- (void)setSingleValue:(int)value type:(int)type;
{
    
    _lblFrom.hidden = YES;
    _lblMinus.hidden = YES;
    if (type == Expertise) {
        if (value == CNC) {
            _lblTo.text = @"CNC";
        } else if (value == Textile){
            _lblTo.text = @"Dệt";
        } else if (value == Mechanical){
            _lblTo.text = @"Cơ khí";
        } else if (value == Carpentry){
            _lblTo.text = @"Mộc";
        } else if (value == Welding){
            _lblTo.text = @"Hàn";
        } else if (value == Electronic){
            _lblTo.text = @"Điện tử";
        } else if (value == Food){
            _lblTo.text = @"Thực phẩm";
        }
    } else if(type == Language){
        if (value == VietNam) {
            _lblTo.text = @"Việt Nam";
        } else if (value == Taiwan){
            _lblTo.text = @"Đài Loan";
        } else if (value == Indonesia){
            _lblTo.text = @"Indonesia";
        }
    } else if(type == Education){
        if (value == JuniorHigh) {
            _lblTo.text = @"Trung học cơ sở";
        } else if (value == High){
            _lblTo.text = @"Trung học phổ thông";
        } else if (value == College){
            _lblTo.text = @"Cao đẳng";
        } else if (value == University){
            _lblTo.text = @"Đại học";
        }
    }
    
}

@end
