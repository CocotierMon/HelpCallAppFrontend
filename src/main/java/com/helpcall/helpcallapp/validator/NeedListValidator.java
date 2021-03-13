package com.helpcall.helpcallapp.validator;

import com.helpcall.helpcallapp.domain.InstitutionDto;
import com.helpcall.helpcallapp.domain.NeedDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NeedListValidator {

    public List<NeedDto> validateNeedListByInstitution(List<InstitutionDto> institution, List<NeedDto> needDto) {
        List<InstitutionDto> needInst = needDto.stream().flatMap(nds -> needDto.stream())
                .map(NeedDto::getInstitution)
                .collect(Collectors.toList());

       List<Long> ids = institution.stream().flatMap(inst -> institution.stream())
               .map(InstitutionDto::getId)
               .collect(Collectors.toList());

        return needDto.stream().flatMap(nds -> needDto.stream())
                .filter(n -> ids.containsAll(needInst))
                .collect(Collectors.toList());
    }
}
