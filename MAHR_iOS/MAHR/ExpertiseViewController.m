//
//  ExpertiseViewController.m
//  MAHR
//
//  Created by Trung Đức on 3/7/16.
//  Copyright © 2016 Trung Đức. All rights reserved.
//

#import "ExpertiseViewController.h"
#import "ExpertiseCell.h"
#import "JobDetailViewController.h"

@interface ExpertiseViewController ()

@end

@implementation ExpertiseViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.title = @"Sở trường";
    
    _tbvExpertise.rowHeight = 65.0f;
    
    _tbvExpertise.tableFooterView = [[UIView alloc]init];

    
}

#pragma mark - Tableview Datasource

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return 7;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    static NSString *cellId = @"expertiseCell";
    
    ExpertiseCell *cell = [tableView dequeueReusableCellWithIdentifier:cellId];
    if (!cell) {
        NSArray *nib = [[NSBundle mainBundle]loadNibNamed:@"ExpertiseCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    if (indexPath.row == 0) {
        cell.lblTitle.text = @"CNC";
    } else if (indexPath.row == 1){
        cell.lblTitle.text = @"Dệt";
    } else if (indexPath.row == 2){
        cell.lblTitle.text = @"Cơ khí";
    } else if (indexPath.row == 3){
        cell.lblTitle.text = @"Mộc";
    } else if (indexPath.row == 4){
        cell.lblTitle.text = @"Hàn";
    } else if (indexPath.row == 5){
        cell.lblTitle.text = @"Điện tử";
    } else if (indexPath.row == 6){
        cell.lblTitle.text = @"Thực phẩm";
    }
    
    return cell;
}

#pragma mark - Tableview Delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    
    [tableView deselectRowAtIndexPath:indexPath animated:NO];
    
    [self.navigationController popViewControllerAnimated:YES];
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
