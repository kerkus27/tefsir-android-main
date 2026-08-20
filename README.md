# Tefsir Android

Tefsir'in native Android uygulaması. iOS sürümüyle (`tefsir-ios-main`) aynı Supabase backend'ine bağlanır; UI/UX, veri modelleri ve API sözleşmeleri iOS'tan birebir referans alınarak Kotlin/Jetpack Compose ile sıfırdan geliştirilir.

## Teknik Yığın

Kotlin, Jetpack Compose, Material 3, Coroutines + Flow, Hilt, Retrofit, Room, Jetpack DataStore.

## Dallanma ve PR Kuralları

- `main` branch'ine doğrudan push/commit yapılmaz.
- Her özellik/refactor için `feature/<isim>` branch'i açılır.
- Her geliştirme `main`'e açıklayıcı bir Pull Request ile bağlanır.

## Ortam Değişkenleri / Secrets

`local.properties` (Git'e eklenmez) içine aşağıdaki anahtarlar eklenmelidir — iOS'taki `Secrets.xcconfig` düzeninin Android karşılığıdır:

```properties
SUPABASE_HOST=your-project-ref.supabase.co
SUPABASE_ANON_KEY=sb_publishable_replace_me
GOOGLE_MAPS_API_KEY=
```

Bu değerler build sırasında `BuildConfig` alanlarına aktarılır; koda gömülmez.

## Durum

Proje iskelet aşamasındadır. Detaylı mimari plan ve modül yol haritası için commit geçmişine ve PR açıklamalarına bakın.
