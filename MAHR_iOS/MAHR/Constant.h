//
//  Constant.h
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#ifndef Constant_h
#define Constant_h



#endif /* Constant_h */

//MARK: Enum

typedef NS_ENUM(int, RegionType) {
    VN,
    IND,
};

typedef NS_ENUM(int, JobType) {
    MaleWorker = 1,
    FemaleWorker,
    HouseMaid,
};

typedef NS_ENUM(int, JobDetailType) {
    Expertise,
    Age,
    Height,
    Weight,
    Language,
    Education,
};

typedef NS_ENUM(int, ExpertiseType) {
    CNC,
    Textile,
    Mechanical,
    Carpentry,
    Welding,
    Electronic,
    Food,
};

typedef NS_ENUM(int, LanguageType) {
    VietNam,
    Taiwan,
    Indonesia,
};

typedef NS_ENUM(int, EducationType) {
    Primary = 1,
    JuniorHigh,
    High,
    Vocational,
    College,
    University,
};


//MARK: Image

#define kNavigatiionBarBackGroundImage                      @"background_navigationbar"

#define kStatusGreenImage                                   @"free"

#define kStatusYellowImage                                  @"waiting"

#define kStatusRedImage                                     @"confirm"


//MARK: Color


#define kLanguageButtonBackgroundHexColor                   @"#29B6F6"

#define kLanguageButtonBackgroundHighLightColor             @"#1B5E20"

#define kNavigationBarBackGroundColor                       @"#29B6F6"



#define kLanguageButtonTextColor                            @"#E8F5E9"

//MARK: API

#define kSkillUrl                                           @"http://api.mahr.adcviet.com/v1/skills"

#define kFilterUrl                                          @"http://api.mahr.adcviet.com/v1/profiles?%@"
