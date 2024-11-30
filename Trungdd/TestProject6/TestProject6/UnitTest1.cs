namespace TestProject6
{
    public class DiemSoTest
    {
        private List<double> scores;

        [SetUp]
        public void SetUp()
        {
            scores = new List<double>
            {
                8.5, 7.0, 9.0, 6.5, 8.0, 5.5, 10.0, 9.5
            };
        }

        [Test]
        public void TestScoreList()
        {
            List<double> expectedScores = new List<double>
            {
                8.5, 7.0, 9.0, 6.5, 8.0, 5.5, 10.0, 9.5
            };

            CollectionAssert.AreEqual(expectedScores, scores, "Danh sách điểm số không khớp!");
        }

        [Test]
        public void TestAddScore()
        {
            scores.Add(7.5);
            Assert.AreEqual(9, scores.Count);
            Assert.IsTrue(scores.Contains(7.5));
        }

        [Test]
        public void TestEditScore()
        {
            int indexToEdit = 2;
            scores[indexToEdit] = 8.5;
            Assert.AreEqual(8.5, scores[indexToEdit]);
        }

        [Test]
        public void TestDeleteScore()
        {
            double scoreToDelete = 5.5;
            scores.Remove(scoreToDelete);
            Assert.AreEqual(7, scores.Count);
            Assert.IsFalse(scores.Contains(5.5));
        }

        [Test]
        public void TestDeleteScoreWithInvalidIndex()
        {
            int invalidIndex = -1;
            Assert.Throws<ArgumentOutOfRangeException>(() => scores.RemoveAt(invalidIndex), "Không nên cho phép xóa với chỉ số không hợp lệ");
        }

        [Test]
        public void TestSearchScoreNotFound()
        {
            double keyword = 12.0;
            Assert.IsFalse(scores.Contains(keyword), "Điểm không nên tồn tại trong danh sách!");
        }

        [Test]
        public void TestClearAllScores()
        {
            scores.Clear();
            Assert.Zero(scores.Count);
        }

        [Test]
        public void TestGetScoreByIdValidId()
        {
            Assert.AreEqual(8.5, scores[0], "Không tìm thấy điểm số đúng với id = 0!");
            Assert.AreEqual(9.0, scores[2], "Không tìm thấy điểm số đúng với id = 2!");
        }

        [Test]
        public void TestRemoveScoreByIdValidId()
        {
            bool result = scores.Remove(6.5);
            Assert.IsTrue(result, "Xóa thất bại với id hợp lệ!");
            Assert.AreEqual(7, scores.Count, "Số lượng điểm số không đúng sau khi xóa!");
            Assert.IsFalse(scores.Contains(6.5), "Điểm số không được xóa đúng!");
        }

        [Test]
        public void TestRemoveScoreByIdInvalidId()
        {
            Assert.IsFalse(scores.Remove(-1), "Phải trả về false cho id không hợp lệ!");
            Assert.IsFalse(scores.Remove(10), "Phải trả về false cho id không hợp lệ!");
            Assert.AreEqual(8, scores.Count, "Danh sách không đúng sau khi thử xóa id không hợp lệ!");
        }

        [Test]
        public void TestUpdateScoreByIdValidId()
        {
            scores[2] = 7.5;
            Assert.AreEqual(7.5, scores[2], "Điểm số không được cập nhật đúng!");
        }

        [Test]
        public void TestUpdateScoreByIdInvalidId()
        {
            Assert.AreEqual(8, scores.Count, "Danh sách điểm số không đúng sau khi thử cập nhật id không hợp lệ!");
        }

        [Test]
        public void TestAddScoreValid()
        {
            scores.Add(7.0);
            Assert.IsTrue(scores.Contains(7.0), "Thêm điểm số thất bại với dữ liệu hợp lệ!");
            Assert.AreEqual(9, scores.Count, "Số lượng điểm số không đúng sau khi thêm!");
            Assert.AreEqual(7.0, scores[scores.Count - 1], "Điểm số mới không được thêm đúng!");
        }
    }
}