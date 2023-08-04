package edu.center.edu_center.Full.GroupFull;

import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqGroup;
import edu.center.edu_center.payload.ResGroup;

import java.util.List;

public interface GroupFullService {

    List<ResGroup> getGroup();

    ApiResponse addGroup(ReqGroup reqGroup);

    ApiResponse editGroup(Integer id, ReqGroup reqGroup);

    ApiResponse deleteGroup(Integer id);

    ResGroup getOneGroup(Integer id);
}
