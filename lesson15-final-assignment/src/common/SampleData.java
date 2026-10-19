package common;

import enums.Category;
import bean.Customer;
import enums.MemberTier;
import bean.Order;
import bean.OrderLine;
import enums.OrderStatus;
import bean.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.MemberTier.*;
import static enums.OrderStatus.*;

/**
 * Dữ liệu đầu vào, không chứa lời giải. Mỗi lời gọi tạo mới cả list và các bean bên trong.
 * List trả về sửa được. Không dùng random hoặc ngày hiện tại để kết quả luôn tái lập được.
 */
public final class SampleData {
    public static final LocalDate REPORT_FROM = LocalDate.of(2026, 7, 1);
    public static final LocalDate REPORT_TO = LocalDate.of(2026, 9, 30);
    public static final LocalDateTime AS_OF = LocalDateTime.of(2026, 10, 1, 0, 0);

    private SampleData() {
    }

    public static List<Customer> customers() {
        return new ArrayList<>(Arrays.asList(
                customer("C001", "  Nguyễn   Minh An ", " AN@Example.com ", " Hồ Chí Minh ", GOLD, "2025-01-10", "2026-06-01T09:00"),
                customer("C002", "Trần Bình", "binh@example.com", "Hà Nội", SILVER, "2025-03-12", "2026-06-01T09:00"),
                customer("C003", " Lê  Chi ", "old.chi@example.com", "Đà Nẵng", STANDARD, "2025-05-20", "2026-06-01T09:00"),
                customer("C004", "Phạm Dũng", null, "Hà Nội", STANDARD, "2025-06-15", "2026-06-01T09:00"),
                customer("C005", "Hoàng Hà", "ha@example.com", "Hồ Chí Minh", SILVER, "2025-08-01", "2026-06-01T09:00"),
                customer("C006", "Võ Khánh", "khanh@example.com", "Đà Nẵng", GOLD, "2026-01-10", "2026-06-01T09:00"),
                customer("C007", "Đỗ Linh", "linh@example.com", "Cần Thơ", STANDARD, "2026-02-01", "2026-06-01T09:00"),
                customer("C008", "Bùi Nam", "nam@example.com", "Hà Nội", SILVER, "2026-03-01", "2026-06-01T09:00"),
                customer("C009", "Mai Ngọc", "ngoc@example.com", "Huế", STANDARD, "2026-04-01", "2026-06-01T09:00"),
                customer("C010", "Trịnh Phúc", "  ", "Huế", GOLD, "2026-05-01", "2026-06-01T09:00"),
                customer(" c003 ", " Lê   Chi ", " CHI@EXAMPLE.COM ", " Đà Nẵng ", SILVER, "2025-05-20", "2026-06-20T10:00"),
                customer("C002", "Trần Bình (bản cũ)", "old.binh@example.com", "Hà Nội", STANDARD, "2025-03-12", "2026-05-01T09:00")
        ));
    }

    public static List<Product> products() {
        return new ArrayList<>(Arrays.asList(
                product("P001", "Java Core", Category.BOOK, "180000", true),
                product("P002", "Clean Code", Category.BOOK, "250000.00", true),
                product("P003", "Bàn phím cơ", Category.ELECTRONICS, "800000", true),
                product("P004", "Chuột không dây", Category.ELECTRONICS, "300000", true),
                product("P005", "Sổ tay", Category.STATIONERY, "50000", true),
                product("P006", "Bút gel", Category.STATIONERY, "10000.00", true),
                product("P007", "Bình giữ nhiệt", Category.LIFESTYLE, "200000", true),
                product("P008", "Túi vải", Category.LIFESTYLE, "100000", true),
                product("P009", "Thuật toán căn bản", Category.BOOK, "250000.0", true),
                product("P010", "Tai nghe mẫu cũ", Category.ELECTRONICS, "500000", false),
                product("P011", "Đèn bàn", Category.ELECTRONICS, "350000", true),
                product("P012", "Lịch để bàn", Category.STATIONERY, "50000.00", true)
        ));
    }

    /** Đơn lịch sử hợp lệ; có đơn ngoài kỳ, nhiều trạng thái và giá mua khác giá danh mục. */
    public static List<Order> orders() {
        return new ArrayList<>(Arrays.asList(
                order("O001", "C001", "2026-07-01T00:00", "2026-07-03T10:00", DELIVERED, GOLD,
                        line("P001", 2, "180000"), line("P005", 4, "50000")),
                order("O002", "C002", "2026-07-05T09:00", "2026-07-07T09:00", DELIVERED, SILVER,
                        line("P003", 1, "750000"), line("P004", 1, "300000")),
                order("O003", "C003", "2026-07-10T10:00", "2026-07-11T10:00", DELIVERED, STANDARD,
                        line("P002", 1, "250000"), line("P006", 5, "10000")),
                order("O004", "C004", "2026-07-12T11:00", null, CANCELLED, STANDARD,
                        line("P003", 2, "800000")),
                order("O005", "C005", "2026-07-20T12:00", "2026-07-23T12:00", DELIVERED, SILVER,
                        line("P007", 2, "200000"), line("P008", 1, "100000")),
                order("O006", "C006", "2026-07-25T08:00", "2026-07-26T08:00", DELIVERED, GOLD,
                        line("P010", 1, "450000"), line("P006", 10, "10000.0")),
                order("O007", "C001", "2026-08-01T09:00", "2026-08-03T09:00", DELIVERED, GOLD,
                        line("P003", 1, "800000"), line("P002", 1, "250000.00")),
                order("O008", "C002", "2026-08-05T09:00", "2026-08-06T09:00", DELIVERED, SILVER,
                        line("P001", 1, "180000"), line("P001", 2, "170000")),
                order("O009", "C003", "2026-08-10T10:00", "2026-08-12T10:00", DELIVERED, SILVER,
                        line("P009", 2, "250000.0")),
                order("O010", "C004", "2026-08-12T11:00", "2026-08-14T11:00", DELIVERED, STANDARD,
                        line("P004", 1, "300000"), line("P005", 2, "50000")),
                order("O011", "C007", "2026-08-15T08:00", null, CANCELLED, STANDARD,
                        line("P008", 3, "100000")),
                order("O012", "C006", "2026-08-20T12:00", "2026-08-22T12:00", DELIVERED, GOLD,
                        line("P002", 2, "250000"), line("P009", 2, "250000")),
                order("O013", "C001", "2026-09-01T09:00", "2026-09-02T09:00", DELIVERED, GOLD,
                        line("P007", 1, "200000"), line("P006", 10, "10000")),
                order("O014", "C005", "2026-09-05T10:00", "2026-09-07T10:00", DELIVERED, SILVER,
                        line("P003", 1, "800000"), line("P004", 2, "300000")),
                order("O015", "C008", "2026-09-10T11:00", "2026-09-12T11:00", DELIVERED, SILVER,
                        line("P001", 2, "180000"), line("P008", 2, "100000")),
                order("O016", "C004", "2026-09-15T14:00", "2026-09-17T14:00", DELIVERED, STANDARD,
                        line("P005", 10, "45000"), line("P006", 10, "10000")),
                order("O017", "C003", "2026-09-20T15:00", "2026-09-21T15:00", DELIVERED, SILVER,
                        line("P007", 1, "200000"), line("P008", 1, "100000")),
                order("O018", "C008", "2026-09-25T10:00", null, CONFIRMED, SILVER,
                        line("P003", 1, "800000")),
                order("O019", "C007", "2026-09-30T23:59:59", null, NEW, STANDARD,
                        line("P002", 1, "250000")),
                order("O020", "C006", "2026-09-28T10:00", "2026-09-30T10:00", DELIVERED, GOLD,
                        line("P004", 1, "300000"), line("P008", 2, "100000")),
                order("O021", "C009", "2026-06-30T23:59:59", "2026-07-02T09:00", DELIVERED, STANDARD,
                        line("P001", 1, "180000")),
                order("O022", "C009", "2026-10-01T00:00", null, NEW, STANDARD,
                        line("P012", 2, "50000")),
                order("O023", "C002", "2026-09-26T10:00", "2026-09-27T10:00", DELIVERED, SILVER,
                        line("P002", 1, "250000")),
                order("O024", "C005", "2026-09-26T10:00", "2026-09-27T10:00", DELIVERED, SILVER,
                        line("P009", 1, "250000.00"))
        ));
    }

    /** Kiểm tra từng phần tử độc lập trên dữ liệu gốc; tuyệt đối không tính vào báo cáo chuẩn. */
    public static List<Order> invalidOrders() {
        return new ArrayList<>(Arrays.asList(
                order("X001", "C999", "2026-09-01T09:00", null, NEW, STANDARD,
                        line("P001", 1, "180000")),
                order("X002", "C001", "2026-09-01T09:00", null, NEW, GOLD,
                        line("P999", 1, "100000")),
                order("X003", "C001", "2026-09-01T09:00", null, NEW, GOLD,
                        line("P001", 0, "180000")),
                order("X004", "C001", "2026-09-01T09:00", null, NEW, GOLD,
                        line("P001", 1, "-180000")),
                order("X005", "C001", "2026-09-01T09:00", null, NEW, GOLD),
                order("X006", "C001", "2026-09-01T09:00", "2026-08-31T09:00", DELIVERED, GOLD,
                        line("P001", 1, "180000")),
                order("X007", "C001", "2026-09-01T09:00", null, DELIVERED, GOLD,
                        line("P001", 1, "180000")),
                order("O001", "C001", "2026-09-01T09:00", null, NEW, GOLD,
                        line("P001", 1, "180000")),
                order("X009", "C001", "2026-09-01T09:00", null, NEW, GOLD,
                        new OrderLine("P001", 1, null)),
                new Order("X010", "C001", LocalDateTime.parse("2026-09-01T09:00"), null, NEW, GOLD, null),
                order("X011", "C001", "2026-09-01T09:00", null, NEW, GOLD, (OrderLine) null),
                order("X012", "C001", "2026-09-01T09:00", "2026-09-02T09:00", NEW, GOLD,
                        line("P001", 1, "180000"))
        ));
    }

    private static Customer customer(String id, String name, String email, String city,
                                     MemberTier tier, String joinedAt, String updatedAt) {
        return new Customer(id, name, email, city, tier,
                LocalDate.parse(joinedAt), LocalDateTime.parse(updatedAt));
    }

    private static Product product(String id, String name, Category category, String price, boolean active) {
        return new Product(id, name, category, new BigDecimal(price), active);
    }

    private static OrderLine line(String productId, int quantity, String price) {
        return new OrderLine(productId, quantity, new BigDecimal(price));
    }

    private static Order order(String id, String customerId, String createdAt, String deliveredAt,
                               OrderStatus status, MemberTier tier, OrderLine... lines) {
        return new Order(id, customerId, LocalDateTime.parse(createdAt),
                deliveredAt == null ? null : LocalDateTime.parse(deliveredAt),
                status, tier, new ArrayList<>(Arrays.asList(lines)));
    }
}
