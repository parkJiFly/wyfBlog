# wyf博客

## 1、登录用户部分

### 1    result

- `@JsonInclude(JsonInclude.Include.NON_NULL)` 确保当 `address` 为null时，它不会被包含在JSON输出中。
- `@Getter` 生成 `getName()`, `getAge()` 和 `getAddress()` 方法。
- `@NoArgsConstructor` 生成一个无参构造函数 `public MyClass() { }`。
