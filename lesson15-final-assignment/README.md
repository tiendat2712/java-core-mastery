# Java Core Final Assignment — Nova Shop

Nova Shop cần một ứng dụng console quản lý đơn hàng và lập báo cáo kinh doanh. Bạn nhận dữ liệu khách hàng, danh mục sản phẩm và lịch sử đơn hàng từ bộ phận vận hành. Hãy biến chúng thành một hệ thống có thể tra cứu, xử lý nghiệp vụ và đưa ra số liệu đáng tin cậy.

Đây là một bài thực hành tổng hợp, không phải danh sách bài tập theo từng lesson. Bạn tự quyết định cách chia lớp, thiết kế phương thức, kiểu dữ liệu kết quả và luồng chương trình. Thời gian gợi ý: **8–12 giờ**, có thể chia nhiều buổi. Chỉ dùng Java Core; không xử lý file, database, framework hay thư viện ngoài.

## Bộ khởi đầu

```text
lesson15-final-assignment/
├── README.md
└── src/
    ├── Main.java
    ├── bean/
    │   ├── Customer.java
    │   ├── Product.java
    │   ├── Order.java
    │   └── OrderLine.java
    ├── enums/
    │   ├── Category.java
    │   ├── MemberTier.java
    │   └── OrderStatus.java
    └── common/
        └── SampleData.java
```

Package **`bean`** chứa các lớp dữ liệu; package **`enums`** chứa các enum (không dùng tên `enum` vì đây là từ khóa Java). Các bean đã có constructor rỗng/đầy đủ, getter/setter và `toString`; không có `equals`, `hashCode`, `compareTo` và không yêu cầu bổ sung các hàm đó. Các bean đang mutable, không tự validation hoặc sao chép dữ liệu. Bạn được thêm lớp kết quả báo cáo nếu cần.

`SampleData` cung cấp 12 bản ghi khách hàng, 12 sản phẩm, 24 đơn lịch sử hợp lệ và 12 tình huống đơn không hợp lệ. Mỗi lần gọi factory trả về list, bean và các dòng hàng mới; có thể sửa chúng để thử nghiệm mà không ảnh hưởng lần gọi kế tiếp. `invalidOrders()` là bộ kiểm thử riêng, không trộn vào doanh thu chuẩn.

Mở module `lesson15-final-assignment` trong IntelliJ và chạy `Main`. Project đang cấu hình JDK 22; bộ khởi đầu cũng biên dịch được với JDK 17. `Main` hiện chỉ nạp dữ liệu và in số lượng, chưa làm thay phần nghiệp vụ. Có thể tạo thêm package `service`, `exception`, `utils`, `view` theo thiết kế của bạn; không cần tạo các lớp rỗng chỉ để đủ package.

## Quy ước nghiệp vụ

Những quy tắc dưới đây là hợp đồng của đề để kết quả có thể đối chiếu, không quy định thuật toán giải.

- **Định danh:** mã khách hàng, sản phẩm, đơn hàng và các mã tham chiếu được bỏ khoảng trắng hai đầu, chuyển chữ hoa. Dùng mã đã chuẩn hóa để xác định cùng thực thể; không dùng tham chiếu object để loại trùng. Với khách hàng trùng mã, giữ toàn bộ bản ghi có `updatedAt` mới nhất; nếu bằng nhau giữ bản xuất hiện trước. Sản phẩm và đơn lịch sử có mã duy nhất.
- **Chuỗi:** tên khách hàng, tên sản phẩm và thành phố được bỏ khoảng trắng thừa, gộp khoảng trắng liên tiếp thành một, giữ dấu và kiểu chữ. Email bỏ khoảng trắng hai đầu, chuyển chữ thường; null hoặc trắng được coi là thiếu và chuẩn hóa thành null. Không cần kiểm tra email bằng regex. Tra cứu tên không phân biệt hoa/thường, vẫn phân biệt dấu. Thứ tự chuỗi dùng so sánh không phân biệt hoa/thường của Java, không yêu cầu thứ tự từ điển tiếng Việt; mã tăng dần là tiêu chí cuối khi đồng hạng.
- **Tiền:** toàn bộ phép tính tiền dùng `BigDecimal`. Tiền dòng hàng = `quantity × unitPrice`; tiền hàng của đơn là tổng các dòng. `unitPrice` lưu giá lúc mua, không lấy `Product.listPrice` để tính lại lịch sử. Hai giá trị chỉ khác scale, ví dụ `250000.0` và `250000.00`, bằng nhau về giá trị tiền.
- **Ưu đãi:** dùng `Order.tierAtPurchase`, không dùng hạng hiện tại trong `Customer`. STANDARD giảm 0%, SILVER giảm 5%, GOLD giảm 10%. Tiền phải trả = tiền hàng × (1 − tỷ lệ giảm), làm tròn **một lần ở cấp đơn**, scale 2, `HALF_UP`. Không VAT, phí vận chuyển, cộng dồn khuyến mại hay hoàn tiền. Doanh thu/chi tiêu là tổng tiền phải trả của các đơn được tính; giá trị trung bình làm tròn scale 2, `HALF_UP`.
- **Kỳ báo cáo:** mặc định từ `REPORT_FROM` đến `REPORT_TO`, bao gồm cả hai ngày, xét theo **ngày tạo đơn**. Chỉ `DELIVERED` trong kỳ được tính doanh thu, chi tiêu, số lượng bán và bảng xếp hạng. Các báo cáo phải nhận được kỳ bất kỳ, không hard-code quý III. Thống kê trạng thái và tra cứu được xét tất cả trạng thái trong kỳ.
- **Thời gian:** dùng `AS_OF` làm mốc kiểm tra đơn chờ, không dùng `now()`. Đơn NEW/CONFIRMED chờ **hơn 72 giờ** kể từ `createdAt` là quá hạn. Ngày hiển thị `dd/MM/yyyy`, thời điểm `dd/MM/yyyy HH:mm`; các thời điểm trong đề cùng giờ địa phương, không cần chuyển múi giờ.
- **Lịch sử:** sản phẩm hiện ngừng bán vẫn có thể xuất hiện trong đơn lịch sử hợp lệ. Khi tạo đơn mới chỉ chấp nhận sản phẩm đang active; chụp giá danh mục và hạng hiện tại của khách hàng vào đơn. Không yêu cầu quản lý tồn kho. Khi danh mục hoặc hạng khách hàng thay đổi sau đó, tiền đơn đã tạo phải giữ nguyên.

## Sản phẩm cần bàn giao

### 1. Nền dữ liệu và tra cứu vận hành — 20 điểm

Nạp, chuẩn hóa và tổ chức dữ liệu để có thể tra cứu nhanh theo mã, không mất bản ghi do xử lý trùng sai. Cho phép tìm đơn bằng tổ hợp các điều kiện tùy chọn: khoảng ngày tạo, trạng thái, từ khóa trong tên khách hàng và khoảng tiền phải trả (bao gồm hai cận). Bỏ trống điều kiện nào thì không lọc theo điều kiện đó. Kết quả có mã đơn, khách hàng, thời điểm tạo, trạng thái và tiền phải trả.

Người dùng chọn một trong ba kiểu sắp xếp: **mới nhất trước**, **tiền phải trả giảm dần rồi ngày tạo tăng dần**, hoặc **email khách hàng tăng dần, email thiếu luôn cuối rồi ngày tạo giảm dần**. Mỗi kiểu đều có mã đơn tăng dần làm tiêu chí cuối. Hỗ trợ phân trang: số trang bắt đầu từ 1, kích thước trang dương; trang vượt dữ liệu trả danh sách rỗng, tổng số kết quả được tính trước khi phân trang.

### 2. Xử lý đơn hàng — 20 điểm

Ứng dụng tạo được đơn mới từ mã khách hàng và các cặp mã sản phẩm/số lượng, tra cứu chi tiết hóa đơn và chuyển trạng thái. Chỉ cho phép `NEW → CONFIRMED → DELIVERED`, `NEW → CANCELLED`, `CONFIRMED → CANCELLED`; các chuyển đổi còn lại, kể cả sang chính trạng thái hiện tại, bị từ chối. Khi giao hàng, nhận thời điểm giao hợp lệ; khi hủy không xóa đơn khỏi lịch sử. Một sản phẩm xuất hiện nhiều lần trong đơn là hợp lệ, kể cả khác giá mua; phải tính đủ từng dòng.

Từ chối đơn null; mã trống/trùng; khách hoặc sản phẩm không tồn tại; thiếu ngày tạo, trạng thái hoặc hạng lúc mua; danh sách dòng null/rỗng/có phần tử null; số lượng không dương; giá null/không dương. Đơn DELIVERED phải có ngày giao không trước ngày tạo; trạng thái khác phải có ngày giao null. Khi tạo mới, trạng thái bắt buộc NEW và áp dụng thêm quy tắc active/giá/hạng nêu trên. Mã đơn có thể do người gọi nhập, không cần bộ sinh mã tự động. Validation lịch sử không áp đặt quy tắc chỉ dành cho đơn mới.

Thiết kế exception nghiệp vụ có thông báo rõ ràng. Thao tác thất bại không được cập nhật dở dang dữ liệu đang lưu, và chương trình phải tiếp tục xử lý tình huống kế tiếp. Minh họa chính sách giảm giá qua một interface và các implementation để vận dụng đa hình; chữ ký phương thức và cách chọn chính sách do bạn thiết kế.

### 3. Báo cáo kinh doanh — 35 điểm

Xây dựng một báo cáo tổng hợp có các góc nhìn sau:

- **Tổng quan:** số đơn theo từng trạng thái (kể cả trạng thái có số lượng 0), doanh thu, giá trị trung bình đơn đã giao, số khách mua thực sự và doanh thu từng tháng trong kỳ theo thứ tự thời gian. Tháng không có doanh thu vẫn hiện 0; nếu kỳ bắt đầu/kết thúc giữa tháng thì chỉ tính các ngày trong kỳ.
- **Khách hàng:** top K khách có ít nhất một đơn được tính, theo chi tiêu giảm dần → số đơn đã giao giảm dần → mã tăng dần; kèm lần mua gần nhất (thời điểm tạo đơn). Lập danh sách khách không có đơn đã giao trong kỳ, bao gồm cả người chưa từng đặt đơn, và tập thành phố của khách có mua, không trùng, tăng dần.
- **Sản phẩm:** top K sản phẩm thực sự bán được trong mỗi category theo tổng số lượng giảm dần → tổng tiền hàng trước giảm giá giảm dần → mã tăng dần. Hiển thị số đơn phân biệt có sản phẩm đó; một đơn có hai dòng cùng sản phẩm chỉ được đếm một lần. Kèm danh sách sản phẩm active chưa bán được trong kỳ, sắp theo category rồi mã tăng dần. Category chưa bán vẫn có nhóm kết quả rỗng.
- **Phân tích chéo:** doanh thu theo thành phố khách hàng → hạng thành viên **lúc mua**, đồng thời đếm số khách phân biệt trong mỗi nhóm. Thành phố lấy từ hồ sơ khách hàng đã chuẩn hóa/loại trùng. Chỉ hiện nhóm phát sinh đơn được tính; thành phố tăng dần, hạng theo thứ tự STANDARD, SILVER, GOLD.
- **Cảnh báo vận hành:** các đơn chờ quá hạn tại `AS_OF`, lấy từ toàn bộ lịch sử, không giới hạn kỳ báo cáo, sắp theo số giờ chờ giảm dần rồi mã tăng dần. Hiển thị số giờ chờ trọn vẹn; quyết định quá hạn dựa trên khoảng thời gian thực, không làm tròn trước khi so ngưỡng.

Top K lấy tối đa K dòng, không lấy thêm mọi dòng đồng hạng; K phải dương. Với dữ liệu rỗng, tổng/đếm/trung bình bằng 0, danh sách rỗng, các tháng trong kỳ vẫn hiện 0. Không giả định luôn có kết quả tìm kiếm hay đơn bán chạy nhất. Khoảng ngày đảo ngược, khoảng tiền đảo ngược/âm và tham số phân trang/K sai phải có thông báo lỗi rõ ràng.

### 4. Thiết kế và chất lượng xử lý — 15 điểm

Tách nhập/xuất console khỏi nghiệp vụ. Dùng List, Set, Map có mục đích rõ ràng, generic có kiểu đầy đủ, lambda/method reference và Comparator nhiều tiêu chí. **Phần báo cáo ở mục 3, trừ cảnh báo vận hành, phải lấy Stream API làm cách xử lý chính**, bao gồm dữ liệu lồng nhiều dòng hàng, gom nhóm, gộp giá trị và xếp hạng; không biến `forEach` thành vòng lặp cập nhật các biến tổng bên ngoài. Bạn tự lựa chọn pipeline phù hợp, không bị yêu cầu viết một chuỗi stream duy nhất thật dài.

Có ít nhất một tiện ích generic được dùng thực sự cho hai kiểu dữ liệu khác nhau, ví dụ hỗ trợ tra cứu hoặc phân trang. Khi trả kết quả có thứ tự, đảm bảo collection và cách in duy trì đúng thứ tự đó. Không sửa danh sách/bean nguồn trong khi tính báo cáo hoặc sắp xếp kết quả tra cứu.

Dựng phần văn bản báo cáo bằng `StringBuilder`, xử lý chuỗi có dấu/null hợp lý. Minh họa trong demo việc chuẩn hóa một `String` cần nhận giá trị mới và việc sửa một `OrderLine` có thể ảnh hưởng các danh sách cùng giữ tham chiếu đến nó; sau đó chứng minh báo cáo của bạn không làm thay đổi dữ liệu nguồn. Không cần trình bày lý thuyết dài.

### 5. Demo và tự kiểm chứng — 10 điểm

Chạy từ `Main` để xem được một luồng hoàn chỉnh: nạp dữ liệu → tra cứu và đổi kiểu sort → báo cáo quý III/2026 với K = 3 → tạo đơn và chuyển trạng thái → xử lý các trường hợp sai. Menu tương tác là tùy chọn; một kịch bản chạy tự động rõ ràng là đủ. Báo cáo đối chiếu ban đầu chạy trước mọi thay đổi nghiệp vụ hoặc trên bộ dữ liệu mới.

Với `invalidOrders()`, thử từng phần tử độc lập trên bộ dữ liệu gốc, báo mã đơn và nguyên nhân từ chối; không cần báo tất cả lỗi cùng lúc. Tự bổ sung trường hợp khoảng thời gian rỗng, giá tiền khác scale, đồng hạng, K lớn hơn số phần tử, đơn chờ đúng 72 giờ, chuyển trạng thái sai và thao tác thất bại không làm đổi dữ liệu. Kiểm tra bộ dữ liệu rỗng và kiểm tra giá/hạng hiện tại thay đổi không làm đổi tiền đơn cũ. Có thể dùng hàm kiểm tra trong console, không bắt buộc JUnit.

Để ôn mảng và thuật toán sort, chuyển một kết quả xếp hạng sản phẩm thành mảng, tự cài một thuật toán đã học và đối chiếu thứ tự mã với kết quả Comparator/Stream trên cùng đầu vào và cùng tiêu chí. Không thay toàn bộ cơ chế sắp xếp của ứng dụng bằng thuật toán thủ công.

Bàn giao mã chạy được cùng ghi chú ngắn trong `SUBMISSION.md`: cách chạy, các quyết định chọn collection, cách bảo vệ dữ liệu nguồn và những ca đã tự kiểm tra. Bạn tự tạo file này khi hoàn thành bài. Không yêu cầu đúng tên phương thức hay bố cục console có sẵn.

## Mốc tự kiểm tra ban đầu

Đây là vài mốc để bắt lỗi sớm, không phải toàn bộ đáp án:

- Sau chuẩn hóa/loại trùng có **10 khách**. C003 giữ bản cập nhật ngày 20/06/2026, email `chi@example.com`, hạng SILVER; C002 không bị bản cũ xuất hiện sau ghi đè. C004 và C010 thiếu email.
- Quý III có **22 đơn**: 18 DELIVERED, 2 CANCELLED, 1 CONFIRMED, 1 NEW. O021 không thuộc kỳ dù giao trong tháng 7; O022 nằm đúng đầu ngày kế tiếp nên không thuộc kỳ.
- O001 có tiền hàng **560000.00**, phải trả **504000.00**. O003 phải trả **300000.00**, không áp dụng hạng SILVER hiện tại của C003.
- O008 có hai dòng P001, tổng **3 sản phẩm**, tiền hàng **520000.00**, phải trả **494000.00**; khi thống kê số đơn chứa P001 chỉ đóng góp **1 đơn**.
- O023 và O024 cùng phải trả **237500.00**, cùng ngày tạo; sort tiền giảm dần/ngày tạo tăng dần phải dùng mã để giữ O023 trước O024 khi so riêng cặp này.

Chấm theo tính đúng đắn và cách vận dụng kiến thức chung, không theo số phương thức Stream đã dùng. Một lời giải tốt phải tiếp tục đúng khi dữ liệu mẫu được thêm, bớt hoặc đảo thứ tự.
