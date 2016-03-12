//
//  Skill.m
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "Skill.h"

@implementation Skill

- (instancetype)initWithJson:(NSDictionary *)jsonDict;
{
    self = [super init];
    
    if (self) {
        if ([jsonDict[@"id"] isKindOfClass:[NSNull class]]) {
            _id = @"";
        } else {
            _id = jsonDict[@"id"];
        }
        if ([jsonDict[@"name"] isKindOfClass:[NSNull class]]) {
            _name = @"";
        } else {
            _name = jsonDict[@"name"];
        }
        if ([jsonDict[@"chinese_name"] isKindOfClass:[NSNull class]]) {
            _chineseName = @"";
        } else {
            _chineseName = jsonDict[@"chinese_name"];
        }
    }
    
    return self;
}

@end
