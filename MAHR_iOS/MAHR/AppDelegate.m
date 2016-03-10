//
//  AppDelegate.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "AppDelegate.h"
#import "Constant.h"
#import "AFNetworking.h"
#import "Skill.h"
#import "HexColors.h"

@interface AppDelegate ()



@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Override point for customization after application launch.
    
    //set up default navigation bar background image    
    [self.window setTintColor:[UIColor hx_colorWithHexRGBAString:kNavigationBarBackGroundColor]];
    
    _skills = [[NSMutableArray alloc]init];
    
    [self loadSkills];
    
    
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application {
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application {
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application {
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application {
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application {
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

- (void)loadSkills;
{
    NSURLSessionConfiguration *configuration = [NSURLSessionConfiguration defaultSessionConfiguration];
    
    AFHTTPSessionManager *httpSessionManager = [[AFHTTPSessionManager alloc]initWithSessionConfiguration:configuration];
    
    NSString *stringUrl = [NSString stringWithFormat:kSkillUrl];
    
    NSURLSessionDataTask *dataTask = [httpSessionManager GET:stringUrl
                                                  parameters:nil
                                                    progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
                                                        if (responseObject) {
                                                            for (NSDictionary *jsonDict in responseObject[@"items"]) {
                                                                Skill *newSkill = [[Skill alloc]initWithJson:jsonDict];
                                                                [_skills addObject:newSkill];
                                                            }
                                                            
                                                        }
                                                    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
                                                        if (error) {
                                                        
                                                            
                                                        }
                                                    }];
    
    [dataTask resume];
    
}

@end
