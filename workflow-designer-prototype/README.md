# 그래프, State Diagram 관련 라이브러리
- Fabric.js
- Paper.js
- MxGraph
- JointJS
- React Flow
- xstate

# 개발 목표
- 요구사항에 적합하고, 목적에 맞게 커스터마이징 가능한 라이브러리가 없음
- Canvas API를 활용하여 직접 워크플로우를 디자인할 수 있는 디자이너 개발

# 고려 사항
- 데이터와 그래픽 데이터에 대한 분리
- MVx 아키텍처 고려
- Data Export/Import 지원

# 속도가 저하될 수 있는 부분
- 변경 사항 발생 시 모든 Path를 다시 그려야 하는데 이 방법 말고는 없을 지
