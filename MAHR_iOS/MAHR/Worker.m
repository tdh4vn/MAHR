//
//  Worker.m
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "Worker.h"

@implementation Worker

- (instancetype)initWithJson:(NSDictionary *)jsonDict;
{
    self = [super init];
    
    if (self) {
        if ([jsonDict[@"name"] isKindOfClass:[NSNull class]]) {
            _name = @"";
        } else {
            _name = jsonDict[@"name"];
        }
        if ([jsonDict[@"age"] isKindOfClass:[NSNull class]]) {
            _age = @"";
        } else {
            _age = [NSString stringWithFormat:@"%@",jsonDict[@"age"]];
        }
        if ([jsonDict[@"height"] isKindOfClass:[NSNull class]]) {
            _height = @"";
        } else {
            _height = [NSString stringWithFormat:@"%@",jsonDict[@"height"]];
        }
        if ([jsonDict[@"weight"] isKindOfClass:[NSNull class]]) {
            _weight = @"";
        } else {
            _weight = [NSString stringWithFormat:@"%@",jsonDict[@"weight"]];
        }
        if ([jsonDict[@"avatar"] isKindOfClass:[NSNull class]]) {
            _avatarUrl = @"";
        } else {
            _avatarUrl = jsonDict[@"avatar"];
        }
        if ([jsonDict[@"excel_path"] isKindOfClass:[NSNull class]]) {
            _exceUrl = @"";
        } else {
            _exceUrl = jsonDict[@"excel_path"];
        }
    }
    
    return self;
}

@end
