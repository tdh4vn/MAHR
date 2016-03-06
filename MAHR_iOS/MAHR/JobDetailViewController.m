//
//  JobDetailViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/6/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "JobDetailViewController.h"
#import "DetailCell.h"

@interface JobDetailViewController ()

@end

@implementation JobDetailViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.title = _jobType;
    _tbvDetails.rowHeight = 65.0f;
    
    _tbvDetails.tableFooterView = [[UIView alloc]init];
    
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return 7;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *cellId = @"detailCell";
    
    DetailCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"DetailCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    if (indexPath.row == 0) {
        cell.lblDetail.text = @"Sở trường";
        cell.imageView.image = [UIImage imageNamed:@"0"];
    } else if (indexPath.row == 1){
        cell.lblDetail.text = @"Tuổi";
        cell.imageView.image = [UIImage imageNamed:@"1"];
    } else if (indexPath.row == 2){
        cell.lblDetail.text = @"Chiều cao";
        cell.imageView.image = [UIImage imageNamed:@"2"];
    } else if (indexPath.row == 3){
        cell.lblDetail.text = @"Cân nặng";
        cell.imageView.image = [UIImage imageNamed:@"3"];
    } else if (indexPath.row == 4){
        cell.lblDetail.text = @"Ngôn ngữ";
        cell.imageView.image = [UIImage imageNamed:@"4"];
    } else if (indexPath.row == 5){
        cell.lblDetail.text = @"Kinh nghiệm";
        cell.imageView.image = [UIImage imageNamed:@"5"];
    } else if (indexPath.row == 6){
        cell.lblDetail.text = @"Trình độ văn hoá";
        cell.imageView.image = [UIImage imageNamed:@"6"];
    }
    
    return cell;
    
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(nonnull NSIndexPath *)indexPath{
    [tableView deselectRowAtIndexPath:indexPath animated:NO];
}

@end
