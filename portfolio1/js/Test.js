document.addEventListener('DOMContentLoaded', function() {
    const images = document.querySelectorAll('.slider-images img');
    const indicators = document.querySelectorAll('.indicator');
    let currentIndex = 0;

    function showSlide(index) {
        // すべての画像とインジケータを非表示にする
        images.forEach((img, i) => {
            img.style.display = i === index ? 'block' : 'none';
            indicators[i].classList.toggle('active', i === index);
        });
    }

    // 最初のスライドを表示
    showSlide(currentIndex);

    // インジケータをクリックしてスライドを切り替える
    indicators.forEach((indicator, index) => {
        indicator.addEventListener('click', () => {
            currentIndex = index;
            showSlide(currentIndex);
        });
    });

    // 画像拡大表示関連
const workImages = document.querySelectorAll('.work-image');
const overlay = document.getElementById('overlay');
const overlayImage = document.getElementById('overlayImage');

// 画像をクリックしたときの処理
workImages.forEach(image => {
    image.addEventListener('click', () => {
        overlayImage.src = image.src; // 拡大画像を設定
        overlay.style.display = 'flex'; // オーバーレイを表示
    });
});

// オーバーレイをクリックしたときの処理
overlay.addEventListener('click', () => {
    overlay.style.display = 'none'; // オーバーレイを非表示
});
});
