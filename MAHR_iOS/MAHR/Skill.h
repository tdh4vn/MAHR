//
//  Skill.h
//  MAHR
//
//  Created by Trung Đức on 3/10/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Skill : NSObject

@property(nonatomic,strong) NSString *id;
@property(nonatomic,strong) NSString *name;
@property(nonatomic,strong) NSString *chineseName;

- (instancetype)initWithJson:(NSDictionary *)jsonDict;

@end
