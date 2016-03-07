//
//  DetailCell.h
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UILabel *lblDetail;
@property (weak, nonatomic) IBOutlet UIImageView *imvIcon;


@property (weak, nonatomic) IBOutlet UILabel *lblFrom;
@property (weak, nonatomic) IBOutlet UILabel *lblMinus;
@property (weak, nonatomic) IBOutlet UILabel *lblTo;

- (void)setValueFrom:(int)startValue to:(int)finishValue;
- (void)setSingleValue:(int)value type:(int)type;

@end
