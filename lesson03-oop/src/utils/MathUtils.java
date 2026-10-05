package utils;

/**
 * Utility class là class chứa các helper methods
 *
 *  Helper methods là những phương thức dùng chung cho nhiều chỗ
 *  và mình sẽ tạo ra các static method trong utility class
 *
 */

public class MathUtils {

    // --> mục đích: muốn class này không bao giờ tạo ra đối tượng
    private MathUtils() {
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

}

/*
 * CÂU HỎI: Có nên tạo private constructor không? Vì sao?
 *
 * TRẢ LỜI:
 *
 * Việc tạo private constructor là CẦN THIẾT trong những trường hợp
 * mà class KHÔNG cho phép hoặc KHÔNG cần khởi tạo object từ bên ngoài.
 * Mục đích chính của private constructor là kiểm soát việc tạo instance
 * và tránh việc sử dụng sai mục đích của class.
 *
 * CỤ THỂ:
 *
 * 1. Util class (class tiện ích):
 *    - Util class chỉ chứa các phương thức static.
 *    - Không có trạng thái (state), không cần object để sử dụng.
 *    - Việc cho phép new object là dư thừa và sai mục đích thiết kế.
 *    => Vì vậy cần private constructor để ngăn việc khởi tạo object.
 *
 * 2. Singleton pattern:
 *    - Singleton yêu cầu toàn hệ thống chỉ tồn tại DUY NHẤT một instance.
 *    - Nếu constructor không phải private, code bên ngoài vẫn có thể new
 *      thêm object, làm phá vỡ Singleton.
 *    => Do đó constructor BẮT BUỘC phải là private.
 *
 * 3. Factory / Static Factory Method:
 *    - Object được tạo thông qua các method static thay vì new trực tiếp.
 *    - Private constructor giúp kiểm soát logic tạo object, validate dữ liệu,
 *      hoặc tái sử dụng instance nếu cần.
 *
 * TRƯỜNG HỢP KHÔNG NÊN dùng private constructor:
 *
 * - Các class domain thông thường (Customer, Product, Employee, ...)
 *   vì cần tạo nhiều object khác nhau.
 *
 * - Builder pattern KHÔNG phải là lý do chính để dùng private constructor.
 *   Trong Builder, constructor private của class chính chỉ nhằm đảm bảo
 *   object được tạo thông qua Builder, chứ Builder pattern không có mục đích
 *   ngăn việc tạo object như Singleton hay Util class.
 *
 * KẾT LUẬN:
 * - Dùng private constructor khi class KHÔNG đại diện cho một đối tượng
 *   trong thế giới thực hoặc cần kiểm soát chặt chẽ việc tạo instance.
 * - Không dùng private constructor cho các class nghiệp vụ thông thường.
 */
