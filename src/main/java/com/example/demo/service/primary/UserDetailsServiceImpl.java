package com.example.demo.service.primary;

//
//@Service
//@Transactional
public class UserDetailsServiceImpl {// implements UserDetailsService {
	//	private UserInfoRepository repo;
	//
	//    //何回以上失敗したらロックするか
	//    int lockingBoundaries = 3;
	//
	//    public UserDetailsServiceImpl(UserInfoRepository repo) {
	//        this.repo = repo;
	//    }
	//
	//    @Override
	//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//        Clients account = repo.findById(username)
	//                .orElseThrow(() -> new UsernameNotFoundException(username));
	//        return User.withUsername(account.getName())
	//                .password(account.getPassword())
	//                // 役割が設定（rolesも引数変わるが権限に使える、権限はStringをカンマ区切りで複数指定できる）
	//                .build();
	//    }

	// ログイン失敗時のハンドラ
	//    @EventListener
	//    public void loginFailureHandle(AuthenticationFailureBadCredentialsEvent event) {
	//        String username = event.getAuthentication().getName();
	//        repo.incrementLoginFailureCount(username);
	//    }

	// ログイン成功時のハンドラ
	//    @EventListener
	//    public void loginSuccessHandle(AuthenticationSuccessEvent event) {
	//        String username = event.getAuthentication().getName();
	//        // ログイン失敗回数を0にする
	//        repo.resetLoginFailureCount(username);
	//    }

}
