package pub.codex.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pub.codex.apix.annotations.Api;
import pub.codex.apix.annotations.ApiOperation;
import pub.codex.apix.annotations.ApiParam;
import pub.codex.apix.annotations.constant.Describe;
import pub.codex.apix.annotations.group.VG;
import pub.codex.common.result.R;
import pub.codex.common.result.RBuilder;
import pub.codex.common.result.RData;
import pub.codex.common.result.RPage;
import pub.codex.core.template.utils.QueryWrapperUtils;
import pub.codex.user.entity.UserEntity;
import pub.codex.user.db.service.UserService;

import java.util.List;

/**
 * 用户示例表
 *
 * @date 2023-04-14 09:59:48
 */
@Api("用户示例表")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
    * 新增接口
    * @param userEntity
    * @return
    */
    @ApiOperation("新增接口")
    @PostMapping("/user")
    public R add(@RequestBody @Validated(VG.Add.class)UserEntity userEntity) {
        userService.save(userEntity);
        return RBuilder.ok();
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
        return RBuilder.ok();
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
        return RBuilder.ok();
    }


    /**
     * 详情接口
     * @param id 根据ID查询
     * @return
     */
    @ApiOperation("详情接口")
    @GetMapping("/user/{id}")
    public RData<UserEntity> detail(@ApiParam(Describe.ID) @PathVariable("id") String id) {
        return RBuilder.build(userService.getById(id));
    }


    /**
     * 列表接口
     * @param  where JSON条件
     *         keyword 关键字
     * @return
     */
    @ApiOperation("列表接口")
    @GetMapping("/user")
    public RData<List<UserEntity>> list(@ApiParam(Describe.WHERE) @RequestParam(required = false) String where,
                  @ApiParam(Describe.KEYWORD) @RequestParam(required = false) String keyword) {


        LambdaQueryWrapper<UserEntity> query = QueryWrapperUtils.setWhereAndKeyword(where, keyword);

        return RBuilder.build(userService.list(query));
    }

    /**
     * 分页接口
     * @param  where 条件JSON对象：字段并集查询
     *         keyword 关键字JSON对象： 字段或集查询
     *         pageIndex 当前页
     *         pageSize 页数
     * @return
     */
    @ApiOperation("分页接口")
    @GetMapping("/user/page")
    public RPage<UserEntity> page(@ApiParam(Describe.WHERE) @RequestParam(required = false) String where,
                                                @ApiParam(Describe.KEYWORD) @RequestParam(required = false) String keyword,
                                                @ApiParam(Describe.PAGE_NUM) @RequestParam(defaultValue = "0") Long pageNum,
                                                @ApiParam(Describe.PAGE_SIZE) @RequestParam(defaultValue = "10") Long pageSize) {


        LambdaQueryWrapper<UserEntity> query = QueryWrapperUtils.setWhereAndKeyword(where, keyword);

        Page<UserEntity> page = userService.page(new Page<>(pageNum, pageSize), query);


        return RBuilder.build(page.getRecords(), page.getCurrent(), page.getSize(), page.getTotal());
    }

}


