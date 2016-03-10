//
//  Worker.h
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Worker : NSObject

@property(nonatomic,strong) NSString *name;
@property(nonatomic,strong) NSString *age;
@property(nonatomic,strong) NSString *height;
@property(nonatomic,strong) NSString *weight;
@property(nonatomic,strong) NSString *avatarUrl;
@property(nonatomic,strong) NSString *exceUrl;
- (instancetype)initWithJson:(NSDictionary *)jsonDict;

@end
