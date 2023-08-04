package edu.center.edu_center.Full.AdminFull;

import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqGroup;
import edu.center.edu_center.payload.ReqGroupforJoin;


public interface AdminServiceFull {

    ApiResponse createGroup(Integer id, ReqGroupforJoin reqGroup);

}
