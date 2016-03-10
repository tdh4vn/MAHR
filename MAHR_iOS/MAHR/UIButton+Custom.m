//
//  UIButton+Custom.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "UIButton+Custom.h"
#import "Constant.h"
#import "HexColors.h"

@implementation UIButton(Custom)

- (void)custom;
{
    self.backgroundColor = [UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHexColor];
    [self setTitleColor:[UIColor hx_colorWithHexRGBAString:kLanguageButtonTextColor] forState:UIControlStateNormal
     ];
    [self setTitleColor:[UIColor hx_colorWithHexRGBAString:kLanguageButtonBackgroundHighLightColor] forState:UIControlStateHighlighted
     ];
    [[self layer] setCornerRadius:20.0f];
    [[self layer] setMasksToBounds:YES];
}

@end
