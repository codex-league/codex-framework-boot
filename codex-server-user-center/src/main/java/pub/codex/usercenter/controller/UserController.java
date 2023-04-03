package pub.codex.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pub.codex.apix.annotations.Api;
import pub.codex.apix.annotations.ApiOperation;
import pub.codex.apix.annotations.ApiParam;
import pub.codex.apix.annotations.constant.Describe;
import pub.codex.apix.annotations.group.VG;
import pub.codex.common.factory.RFactory;
import pub.codex.common.models.R;
import pub.codex.core.template.utils.WhereUtils;
import pub.codex.entity.usercenter.entity.UserEntity;
import pub.codex.db.usercenter.service.UserService;

/**
 * 用户示例表
 *
 * @date 2023-03-31 17:50:52
 */
@Api("用户示例表")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
    * 新增接口
    * @param userEntity
    * @return
    */
    @ApiOperation("新增接口")
    @PostMapping("/user")
    public R add(@RequestBody @Validated(VG.Add.class)UserEntity userEntity) {
        userService.save(userEntity);
        return RFactory.build();
    }


    /**
     * 更新接口
     * @param userEntity
     * @return
     */
    @ApiOperation("更新接口")
    @PutMapping("/user")
    public R update(@RequestBody @Validated(VG.Update.class)UserEntity userEntity) {
        userService.updateById(userEntity);
        return RFactory.build();
    }


    /**
     * 删除接口
     * @param id 根据ID删除
     * @return
     */
    @ApiOperation("删除接口")
    @DeleteMapping("/user/{id}")
    public R delete(@ApiParam(Describe.ID) @PathVariable("id") String id) {
        userService.removeById(id);
        return RFactory.build();
    }


    /**
     * 详情接口
     * @param id 根据ID查询
     * @return
     */
    @ApiOperation("详情接口")
    @GetMapping("/user/{id}")
    public R<UserEntity> detail(@ApiParam(Describe.ID) @PathVariable("id") String id) {
        return RFactory.build(UserEntity.class, userService.getById(id));
    }


    /**
     * 列表接口
     * @param  where JSON条件
     *         pageIndex 当前页
     *         pageSize 页数
     * @return
     */
    @ApiOperation("列表接口")
    @GetMapping("/user")
    public R<Page<UserEntity>> list(@ApiParam(Describe.WHERE) @RequestParam(required = false) String where,
                  @ApiParam(Describe.KEYWORD) @RequestParam(required = false) String keyword,
                  @ApiParam(Describe.PAGE_INDEX) @RequestParam(defaultValue = "0") Long pageIndex,
                  @ApiParam(Describe.PAGE_SIZE) @RequestParam(defaultValue = "10") Long pageSize) {

        QueryWrapper<UserEntity> entity = new QueryWrapper<>();

        WhereUtils.setWhereAndKeyword(entity, where, keyword);

        return RFactory.build(new TypeReference<Page<UserEntity>>() {
        }, userService.page(new Page<>(pageIndex, pageSize), entity));
    }

}


