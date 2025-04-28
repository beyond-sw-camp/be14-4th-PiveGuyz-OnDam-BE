package com.piveguyz.ondambackend.counsel.command.application.service;

import com.piveguyz.ondambackend.counsel.command.application.dto.CounselCommandDTO;

public interface CounselCommandService {
    CounselCommandDTO.Response createCounsel(CounselCommandDTO.CreateRequest request);

    CounselCommandDTO.Response updateCounsel(Long counselId, CounselCommandDTO.UpdateRequest request);

    CounselCommandDTO.Response updateNextCounselDate(Long counselId,
            CounselCommandDTO.UpdateNextCounselDateRequest request);

    void deleteCounsel(Long counselId);
}