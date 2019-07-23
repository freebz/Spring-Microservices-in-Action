# 코드 10-4 깃허브 릴리스 API로 10장의 코드 저장소에 태그 달기

echo "Tagging build with $BUILD_NAME"
export TARGET_URL="https://api.github.com/repos/klimtever/spmia-chapter10/
releases?access_token=$GITHUB_TOKEN"

body="{
  \"tag_name\": \"$BUILD_NAME\",
  \"target_commitish\": \"master\",
  \"body\": \"Release of version $BUILD_NAME\",
  \"draft\": true,
  \"prerelease\": true
}"

curl -k -X POST \
     -H "Content-Type: application/json" \
     -d "$body" \
     $TARGET_URL
