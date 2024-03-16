package com.lipanre.jvm.stack.mapstruct.mapper;

/**
 * @author LiPan
 */
public interface BaseMapStructConverter<DOMAIN, DTO> {



    /**
     * domain转DTO
     *
     * @param domain 待转换的实体对象
     * @return 转换后的DTO对象
     */
    DTO domainToDTO(DOMAIN domain);

}
